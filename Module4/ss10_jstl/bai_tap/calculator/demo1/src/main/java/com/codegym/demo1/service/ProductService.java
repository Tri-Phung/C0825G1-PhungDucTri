package com.codegym.demo1.service;

import com.codegym.demo1.entity.Product;
import com.codegym.demo1.repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService{
    ProductRepository productRepository = new ProductRepository();
    @Override
    public List<Product> findAllByName(String name) {
        return productRepository.findAllByName(name);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public boolean save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public boolean delete(Integer id) {
        return productRepository.delete(id);
    }

    @Override
    public boolean updateById(Integer id,Product product) {
        return productRepository.updateById(id,product);
    }
}
