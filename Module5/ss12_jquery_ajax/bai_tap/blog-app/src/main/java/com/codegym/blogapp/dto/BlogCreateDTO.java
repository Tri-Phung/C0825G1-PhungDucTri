package com.codegym.blogapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogCreateDTO {
    @NotBlank(message = "Title is required")
    private String title;
    
    private String summary;
    
    @NotBlank(message = "Content is required")
    private String content;
    
    @NotBlank(message = "Author is required")
    private String author;
    
    @NotNull(message = "Category is required")
    private Long categoryId;
}

