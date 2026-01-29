package com.codegym.productmanagement.controller;

import com.codegym.productmanagement.entity.Product;
import com.codegym.productmanagement.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String search(@RequestParam("name") String name, Model model){
        model.addAttribute("products", productService.findByName(name));
        return "product/index";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("product") Product product, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        if(product.getName().isEmpty()){
            bindingResult.rejectValue("name","error.name","Name is required!");
        }
        if (product.getPrice() < 0) {
            bindingResult.rejectValue("price", "error.price", "Price should be positive!");
        }
        if (product.getQuantity() < 0) {
            bindingResult.rejectValue("quantity", "error.quantity", "Quantity should be positive!");
        }
        if (bindingResult.hasErrors()) {
            return "product/add";
        }
        productService.save(product);
        redirectAttributes.addFlashAttribute("message", "Product created successfully.");
        return "redirect:/products";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("product") Product product, BindingResult bindingResult,RedirectAttributes redirectAttributes, Model model){
        if(product.getName().isEmpty()){
            bindingResult.rejectValue("name","error.name","Name is required!");
        }
        if (product.getPrice() < 0) {
            bindingResult.rejectValue("price", "error.price", "Price should be positive!");
        }
        if (product.getQuantity() < 0) {
            bindingResult.rejectValue("quantity", "error.quantity", "Quantity should be positive!");
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
