package com.codegym.productmanagement.service;

import com.codegym.productmanagement.entity.Product;

import java.util.List;

public interface IProductService extends IService<Product> {
    List<Product> findByName(String name);
}
