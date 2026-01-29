package com.codegym.cartmanagement.controller;

import com.codegym.cartmanagement.entity.Cart;
import com.codegym.cartmanagement.entity.Product;
import com.codegym.cartmanagement.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
@SessionAttributes("cart")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @ModelAttribute("cart")
    public Cart initCart() {
        return new Cart();
    }


    @GetMapping({""})
    public String listProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product/list";
    }


    @GetMapping("/{id}")
    public String productDetail(@PathVariable Long id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "product/detail";
    }


    @PostMapping("/{id}/buy-now")
    public String buyNow(@PathVariable Long id,
                         @ModelAttribute("cart") Cart cart,
                         RedirectAttributes redirectAttributes) {
        Product product = productService.findById(id);

        if (product.getStock() <= 0) {
            redirectAttributes.addFlashAttribute("error", "Sản phẩm đã hết hàng!");
            return "redirect:/products/" + id;
        }

        cart.clear();
        cart.addItem(product);
        return "redirect:/cart/checkout";
    }
}