package com.codegym.productmanagementspringboot.controller;

import com.codegym.productmanagementspringboot.entity.Product;
import com.codegym.productmanagementspringboot.service.ProductService;
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
    ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
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
        Product product = productService.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        model.addAttribute("product", product);
        return "product/edit";
    }

    @GetMapping("/{id}/detail")
    public String showDetail(@PathVariable("id") int id, Model model){
        Product product = productService.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        model.addAttribute("product", product);
        return "product/detail";
    }

    @GetMapping("/search")
    public String search(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "minPrice", required = false) String minPrice, @RequestParam(value = "maxPrice", required = false) String maxPrice, Model model)
    {
        BigDecimal min = null;
        BigDecimal max = null;
        String errorMessage = "";
        try {
            if (minPrice != null && !minPrice.isEmpty()) min = new BigDecimal(minPrice);
            if (maxPrice != null && !maxPrice.isEmpty()) max = new BigDecimal(maxPrice);
        } catch (NumberFormatException e) {
            errorMessage = "Price should be a number!";
        }
        if (!errorMessage.isEmpty()) {
            model.addAttribute("products", productService.findAll());
            model.addAttribute("message", errorMessage);
        }
        else {
            List<Product> products = productService.search(name, min, max);
            model.addAttribute("products", products);
        }
        model.addAttribute("name", name);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
        return "product/index";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            return "product/add";
        }
        productService.save(product);
        redirectAttributes.addFlashAttribute("message", "Product created successfully.");
        return "redirect:/products";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult,RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            return "product/edit";
        }
        productService.save(product);
        redirectAttributes.addFlashAttribute("message", "Product updated successfully.");
        return "redirect:/products";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam("id") int id,
                         @RequestParam(value = "name", required = false) String name,
                         @RequestParam(value = "minPrice", required = false) String minPrice,
                         @RequestParam(value = "maxPrice", required = false) String maxPrice,
                         RedirectAttributes redirectAttributes){
        productService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Product deleted successfully.");
        if ((name != null && !name.isEmpty()) ||
                (minPrice != null && !minPrice.isEmpty()) ||
                (maxPrice != null && !maxPrice.isEmpty())) {

            String redirectUrl = "/products/search?";
            if (name != null && !name.isEmpty()) redirectUrl += "name=" + name + "&";
            if (minPrice != null && !minPrice.isEmpty()) redirectUrl += "minPrice=" + minPrice + "&";
            if (maxPrice != null && !maxPrice.isEmpty()) redirectUrl += "maxPrice=" + maxPrice;

            return "redirect:" + redirectUrl;
        }
        return "redirect:/products";
    }
}
