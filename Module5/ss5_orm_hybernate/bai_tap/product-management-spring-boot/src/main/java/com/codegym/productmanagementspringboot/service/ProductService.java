package com.codegym.productmanagementspringboot.service;

import com.codegym.productmanagementspringboot.entity.Product;
import com.codegym.productmanagementspringboot.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() { return productRepository.findAll(); }
    public Optional<Product> findById(Integer id) { return productRepository.findById(id); }
    public Product save(Product product) { return productRepository.save(product); }
    public void delete(Integer id) { productRepository.deleteById(id); }
    public List<Product> search(String name, BigDecimal minPrice, BigDecimal maxPrice) { return productRepository.search(name, minPrice, maxPrice); }
}
