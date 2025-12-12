package com.codegym.demo.service;

import java.util.List;

public interface IService<T> {
    List<T> getAll();
    T getById(int id);
    void save(T t);
    void delete(int id);
    void update(T t);
}
