package com.codegym.cartmanagement.controller;

import com.codegym.cartmanagement.entity.Cart;
import com.codegym.cartmanagement.entity.CartItem;
import com.codegym.cartmanagement.entity.Product;
import com.codegym.cartmanagement.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cart")
@SessionAttributes("cart")
public class CartController {

    private final ProductService productService;

    public CartController(ProductService productService) {
        this.productService = productService;
    }

    @ModelAttribute("cart")
    public Cart initCart() {
        return new Cart();
    }

    @GetMapping("")
    public String viewCart(@ModelAttribute("cart") Cart cart, Model model) {
        model.addAttribute("cartItems", cart.getItems().values());
        model.addAttribute("totalPrice", cart.getTotalPrice());
        return "product/cart";
    }

    @PostMapping("/add/{productId}")
    public String addToCart(@PathVariable Long productId,
                            @ModelAttribute("cart") Cart cart,
                            RedirectAttributes redirectAttributes) {
        Product product = productService.findById(productId);

        CartItem existingItem = cart.getItems().get(productId);
        int currentQuantity = (existingItem != null) ? existingItem.getQuantity() : 0;

        if (currentQuantity >= product.getStock()) {
            redirectAttributes.addFlashAttribute("error", "Số lượng trong kho không đủ!");
            return "redirect:/products/" + productId;
        }

        cart.addItem(product);
        redirectAttributes.addFlashAttribute("success", "Đã thêm sản phẩm vào giỏ hàng!");
        return "redirect:/products/" + productId;
    }

    @PostMapping("/update/{productId}")
    public String updateQuantity(@PathVariable Long productId,
                                 @RequestParam Integer quantity,
                                 @ModelAttribute("cart") Cart cart,
                                 RedirectAttributes redirectAttributes) {
        Product product = productService.findById(productId);

        if (product != null && quantity > product.getStock()) {
            redirectAttributes.addFlashAttribute("error",
                    "Số lượng vượt quá tồn kho (còn " + product.getStock() + " sản phẩm)");
            return "redirect:/cart";
        }

        if (quantity <= 0) {
            cart.removeItem(productId);
            redirectAttributes.addFlashAttribute("success", "Đã xóa sản phẩm!");
        } else {
            cart.updateQuantity(productId, quantity);
        }

        return "redirect:/cart";
    }


    @PostMapping("/remove/{productId}")
    public String removeItem(@PathVariable Long productId,
                             @ModelAttribute("cart") Cart cart,
                             RedirectAttributes redirectAttributes) {
        cart.removeItem(productId);
        redirectAttributes.addFlashAttribute("success", "Đã xóa sản phẩm khỏi giỏ hàng!");
        return "redirect:/cart";
    }


    @PostMapping("/checkout")
    public String checkout(@ModelAttribute("cart") Cart cart,
                           RedirectAttributes redirectAttributes) {
        if (cart.getItems().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Giỏ hàng trống!");
            return "redirect:/cart";
        }

        // Trừ stock trong database
        for (CartItem item : cart.getItems().values()) {
            Product product = productService.findById(item.getProductId());
            if (product != null) {
                int newStock = product.getStock() - item.getQuantity();
                if (newStock < 0) {
                    redirectAttributes.addFlashAttribute("error",
                            "Sản phẩm '" + product.getName() + "' không đủ số lượng trong kho!");
                    return "redirect:/cart";
                }
                product.setStock(newStock);
                productService.save(product);
            }
        }

        cart.clear();
        return "redirect:/cart/checkout-success";
    }

    @GetMapping("/checkout")
    public String checkoutPage(@ModelAttribute("cart") Cart cart, Model model) {
        if (cart.getItems().isEmpty()) {
            return "redirect:/products";
        }
        model.addAttribute("cartItems", cart.getItems().values());
        model.addAttribute("totalPrice", cart.getTotalPrice());
        return "product/checkout";
    }

    @GetMapping("/checkout-success")
    public String checkoutSuccess() {
        return "product/checkout-success";
    }
}