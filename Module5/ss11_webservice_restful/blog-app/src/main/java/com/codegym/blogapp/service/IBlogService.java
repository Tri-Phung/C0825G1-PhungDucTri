package com.codegym.blogapp.service;

import com.codegym.blogapp.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService extends IService<Blog>{
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findByCategoryId(Long categoryId, Pageable pageable);
    Page<Blog> search(String keyword, Long categoryId, Pageable pageable);
}
