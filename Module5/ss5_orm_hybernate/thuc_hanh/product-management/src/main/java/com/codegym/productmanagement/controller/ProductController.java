package com.codegym.productmanagement.controller;

import com.codegym.productmanagement.entity.Product;
import com.codegym.productmanagement.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService = new ProductService();

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("products", productService.findAll());
        return "product/index";
    }

    @GetMapping("/add")
    public String showAddForm(Model model){
        model.addAttribute("product", new Product());
        return "product/add";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable("id") int id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "product/edit";
    }

    @GetMapping("/{id}/detail")
    public String showDetail(@PathVariable("id") int id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "product/detail";
    }

    @GetMapping("/search")
    public String search(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "minPrice", required = false) BigDecimal minPrice, @RequestParam(value = "maxPrice", required = false) BigDecimal maxPrice, Model model)
    {
        List<Product> products = productService.search(name, minPrice, maxPrice);
        model.addAttribute("products", products);
        model.addAttribute("name", name);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
        return "product/index";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        if(product.getQuantity() != null && product.getQuantity().toString().contains(".")) {
            bindingResult.rejectValue("quantity", "error.quantity", "Quantity should be an integer!");
        }
        if (bindingResult.hasErrors()) {
            return "product/add";
        }
        productService.save(product);
        redirectAttributes.addFlashAttribute("message", "Product created successfully.");
        return "redirect:/products";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult,RedirectAttributes redirectAttributes, Model model){
        if(product.getQuantity() != null && product.getQuantity().toString().contains(".")) {
            bindingResult.rejectValue("quantity", "error.quantity", "Quantity should be an integer!");
        }
        if (bindingResult.hasErrors()) {
            return "product/edit";
        }
        productService.update(product);
        redirectAttributes.addFlashAttribute("message", "Product updated successfully.");
        return "redirect:/products";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam("id") int id, RedirectAttributes redirectAttributes){
        productService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Product deleted successfully.");
        return "redirect:/products";
    }
}
