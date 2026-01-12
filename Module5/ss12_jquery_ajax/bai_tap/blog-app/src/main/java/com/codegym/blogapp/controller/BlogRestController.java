package com.codegym.blogapp.controller;

import com.codegym.blogapp.dto.BlogCreateDTO;
import com.codegym.blogapp.dto.BlogDetailDTO;
import com.codegym.blogapp.dto.BlogListDTO;
import com.codegym.blogapp.entity.Blog;
import com.codegym.blogapp.entity.Category;
import com.codegym.blogapp.service.BlogService;
import com.codegym.blogapp.service.CategoryService;
import com.codegym.blogapp.service.IBlogService;
import jakarta.persistence.NoResultException;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
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
import java.util.Map;

@RestController
@RequestMapping("/api/blogs")
public class BlogRestController {

    private final IBlogService blogService;
    private final CategoryService categoryService;

    public BlogRestController(BlogService blogService, CategoryService categoryService) {
        this.blogService = blogService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<?> getAllBlogs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "desc") String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase("asc")
                ? Sort.by("createdAt").ascending()
                : Sort.by("createdAt").descending();
        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Blog> blogs = blogService.findAll(pageable);
        if (blogs.hasContent()) {
            Page<BlogListDTO> blogDTOs = blogs.map(BlogListDTO::new);
            return new ResponseEntity<>(blogDTOs, HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogDetailDTO> getBlogById(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        if (blog != null) {
            return new ResponseEntity<>(new BlogDetailDTO(blog), HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> addBlog(@Valid @RequestBody BlogCreateDTO blogCreateDTO) {
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogCreateDTO, blog);
        Category category = categoryService.findById(blogCreateDTO.getCategoryId());
        blog.setCategory(category);
        blogService.save(blog);
        return new ResponseEntity<>(new BlogDetailDTO(blog), HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam(defaultValue = "") String keyword,
                                    @RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<Blog> blogs = blogService.search(keyword, null, pageable);
        Page<BlogListDTO> blogDTOs = blogs.map(BlogListDTO::new);
        return new ResponseEntity<>(blogDTOs, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class, NoResultException.class})
    public Map<String, String> handleExceptions(Exception ex) {
        Map<String, String> errors = new HashMap<>();
        if (ex instanceof MethodArgumentNotValidException validationEx) {
            validationEx.getBindingResult().getAllErrors().forEach((error) -> {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errors.put(fieldName, errorMessage);
            });
        } else if (ex instanceof NoResultException) {
            errors.put("error", ex.getMessage());
        }
        return errors;
    }
}



