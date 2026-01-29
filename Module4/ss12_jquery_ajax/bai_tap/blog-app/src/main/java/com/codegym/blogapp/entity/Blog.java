package com.codegym.blogapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "blogs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Title is required")
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "summary", length = 500)
    private String summary;
    @NotBlank(message = "Content is required")
    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content;
    @NotBlank(message = "Author is required")
    @Column(name = "author", nullable = false)
    private String author;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "update_at")
    private LocalDateTime updatedAt;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
