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
public class BlogDetailDTO {
    private Long id;
    private String title;
    private String summary;
    private String content;
    private String author;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Category category;

    public BlogDetailDTO(Blog blog) {
        this.id = blog.getId();
        this.title = blog.getTitle();
        this.summary = blog.getSummary();
        this.content = blog.getContent();
        this.author = blog.getAuthor();
        this.createdAt = blog.getCreatedAt();
        this.updatedAt = blog.getUpdatedAt();
        this.category = blog.getCategory();
    }
}

