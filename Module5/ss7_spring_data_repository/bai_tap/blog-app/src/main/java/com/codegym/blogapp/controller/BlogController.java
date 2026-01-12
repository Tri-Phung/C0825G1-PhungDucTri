package com.codegym.blogapp.controller;

import com.codegym.blogapp.entity.Blog;
import com.codegym.blogapp.service.BlogService;
import com.codegym.blogapp.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    BlogService blogService;
    CategoryService categoryService;
    public BlogController(BlogService blogService, CategoryService categoryService) {
        this.blogService = blogService;
        this.categoryService = categoryService;
    }
    @GetMapping("")
    public String list(@RequestParam(value = "keyword", required = false) String keyword, @RequestParam(value = "categoryId", required = false) Long categoryId, @RequestParam(value = "sortDir", defaultValue = "desc") String sortDir, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size, Model model){
        Sort sort = sortDir.equals("asc")
                ? Sort.by("createdAt").ascending()
                : Sort.by("createdAt").descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Blog> blogs = blogService.search(keyword,categoryId,pageable);
        model.addAttribute("blogs", blogs);
        model.addAttribute("keyword", keyword);
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("sortDir", sortDir);
        return "blogs/list";
    }
    @GetMapping("/add")
    public String showAddForm(Model model){
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", categoryService.findAll());
        return "blogs/add";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable("id") Long id, Model model){
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        model.addAttribute("categories", categoryService.findAll());
        return "blogs/edit";
    }

    @GetMapping("/{id}/detail")
    public String showDetail(@PathVariable("id") Long id, Model model){
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        model.addAttribute("category", blog.getCategory());
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
    @GetMapping("/ajax")
    public String showAjaxPage(){
        return "blogs/ajax";
    }
}
