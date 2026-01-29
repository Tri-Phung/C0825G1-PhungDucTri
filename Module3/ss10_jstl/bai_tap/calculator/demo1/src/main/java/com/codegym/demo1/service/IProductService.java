package com.codegym.demo1.service;

import com.codegym.demo1.entity.Product;

import java.util.List;

public interface IProductService extends IService<Product>{
    List<Product> findAllByName(String name);
}
