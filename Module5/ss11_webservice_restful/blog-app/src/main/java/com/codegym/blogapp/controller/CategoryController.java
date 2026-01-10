package com.codegym.blogapp.controller;

import com.codegym.blogapp.entity.Category;
import com.codegym.blogapp.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping("")
    public String list(Model model){
        model.addAttribute("categories", categoryService.findAll());
        return "categories/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model){
        model.addAttribute("category", new Category());
        return "categories/add";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable("id") Long id, Model model){
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "categories/edit";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("category") Category category, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "categories/add";
        }
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "Category has been created successfully.");
        return "redirect:/categories";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute("category") Category category, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "categories/edit";
        }
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "Category has been updated successfully.");
        return "redirect:/categories";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id, RedirectAttributes redirectAttributes){
        categoryService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Category has been deleted successfully.");
        return "redirect:/categories";
    }
}
