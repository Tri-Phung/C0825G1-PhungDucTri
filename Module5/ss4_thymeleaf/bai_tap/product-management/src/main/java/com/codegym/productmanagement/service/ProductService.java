package com.codegym.productmanagement.service;

import com.codegym.productmanagement.entity.Product;
import com.codegym.productmanagement.repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService{
    private final ProductRepository productRepository = new ProductRepository();
    @Override
    public List findAll() {
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

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }
}
