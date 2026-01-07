package com.codegym.blogapp.service;

import com.codegym.blogapp.entity.Blog;
import com.codegym.blogapp.repository.BlogRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.NoResultException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    BlogRepository blogRepository;
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No blog found with id: " + id));
    }

    @Override
    public Blog save(Blog entity) {
        return blogRepository.save(entity);
    }

    @Override
    public boolean delete(Long id) {
        if(blogRepository.existsById(id)) {
            blogRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findByCategoryId(Long categoryId, Pageable pageable) {
        return blogRepository.findByCategoryId(categoryId, pageable);
    }

    @Override
    public Page<Blog> search(String keyword, Long categoryId,Pageable pageable) {
        return blogRepository.search(keyword, categoryId, pageable);
    }
}
