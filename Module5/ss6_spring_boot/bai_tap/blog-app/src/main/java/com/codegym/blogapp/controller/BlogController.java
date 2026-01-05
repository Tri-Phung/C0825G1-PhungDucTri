package com.codegym.blogapp.controller;

import com.codegym.blogapp.entity.Blog;
import com.codegym.blogapp.service.BlogService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    BlogService blogService;
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }
    @GetMapping("")
    public String list(Model model){
        model.addAttribute("blogs", blogService.findAll());
        return "blogs/list";
    }
    @GetMapping("/add")
    public String showAddForm(Model model){
        model.addAttribute("blog", new Blog());
        return "blogs/add";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable("id") Long id, Model model){
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "blogs/edit";
    }

    @GetMapping("/{id}/detail")
    public String showDetail(@PathVariable("id") Long id, Model model){
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "blogs/detail";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("blog") Blog blog, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "blogs/add";
        }
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Blog has been created successfully.");
        return "redirect:/blogs";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute("blog") Blog blog, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "blogs/edit";
        }
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Blog has been updated successfully.");
        return "redirect:/blogs/" +  blog.getId() + "/detail";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id, RedirectAttributes redirectAttributes){
        blogService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Blog has been deleted successfully.");
        return "redirect:/blogs";
    }
}
