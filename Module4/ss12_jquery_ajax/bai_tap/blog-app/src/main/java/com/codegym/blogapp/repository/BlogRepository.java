package com.codegym.blogapp.repository;

import com.codegym.blogapp.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    Page<Blog> findByTitleContainingIgnoreCase(String title, Pageable pageable);
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findByCategoryId(Long categoryId, Pageable pageable);
    @Query(value = "SELECT b FROM blogs b WHERE " +
            "(:keyword IS NULL OR LOWER(b.title) LIKE LOWER(CONCAT('%', :keyword, '%'))) AND " +
            "(:categoryId IS NULL OR b.category.id = :categoryId)")
    Page<Blog> search(@Param("keyword") String keyword,
                      @Param("categoryId") Long categoryId,
                      Pageable pageable);
}
