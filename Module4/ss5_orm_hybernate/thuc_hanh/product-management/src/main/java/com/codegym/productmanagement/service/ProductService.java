package com.codegym.productmanagement.service;

import com.codegym.productmanagement.entity.Product;
import com.codegym.productmanagement.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService implements IProductService{
    ProductRepository productRepository = new ProductRepository();
    @Override
    public List<Product> search(String name, BigDecimal minPrice, BigDecimal maxPrice) {
        return productRepository.search(name,minPrice,maxPrice);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);
    }
}
