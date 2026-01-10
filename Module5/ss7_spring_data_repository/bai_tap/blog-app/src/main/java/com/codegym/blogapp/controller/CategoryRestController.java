package com.codegym.blogapp.controller;

import com.codegym.blogapp.dto.BlogListDTO;
import com.codegym.blogapp.entity.Blog;
import com.codegym.blogapp.entity.Category;
import com.codegym.blogapp.service.BlogService;
import com.codegym.blogapp.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/categories")
public class CategoryRestController {

    private final CategoryService categoryService;
    private final BlogService blogService;

    public CategoryRestController(CategoryService categoryService, BlogService blogService) {
        this.categoryService = categoryService;
        this.blogService = blogService;
    }

    @GetMapping
    public ResponseEntity<?> getAllCategories() {
        List<Category> categories = categoryService.findAll();
        if (categories == null || categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addCategory(@Valid @RequestBody Category category) {
        categoryService.save(category);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @GetMapping("/{categoryId}/blogs")
    public ResponseEntity<?> getBlogsByCategory(
            @PathVariable Long categoryId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<Blog> blogs = blogService.findByCategoryId(categoryId, pageable);
        Page<BlogListDTO> blogDTOs = blogs.map(BlogListDTO::new);
        if (blogDTOs.hasContent()) return new ResponseEntity<>(blogDTOs, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}


