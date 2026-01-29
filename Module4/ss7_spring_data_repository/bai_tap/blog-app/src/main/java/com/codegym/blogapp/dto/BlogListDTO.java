package com.codegym.blogapp.dto;

import com.codegym.blogapp.entity.Blog;
import com.codegym.blogapp.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogListDTO {
    private Long id;
    private String title;
    private String summary;
    private String author;
    private LocalDateTime createdAt;
    private Category category;

    public BlogListDTO(Blog blog) {
        this.id = blog.getId();
        this.title = blog.getTitle();
        this.summary = blog.getSummary();
        this.author = blog.getAuthor();
        this.createdAt = blog.getCreatedAt();
        this.category = blog.getCategory();
    }
}

