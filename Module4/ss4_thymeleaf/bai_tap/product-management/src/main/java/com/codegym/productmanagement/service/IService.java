package com.codegym.productmanagement.service;

import java.util.List;

public interface IService<T> {
    List<T> findAll();
    T findById(int id);
    void save(T product);
    void delete(int id);
    void update(T product);
}
