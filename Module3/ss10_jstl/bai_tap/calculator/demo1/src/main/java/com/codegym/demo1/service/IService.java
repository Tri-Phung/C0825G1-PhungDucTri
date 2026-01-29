package com.codegym.demo1.service;

import java.util.List;

public interface IService<T> {
    List<T> findAll();
    T findById(Integer id);
    boolean save(T entity);
    boolean delete(Integer id);
    boolean updateById(Integer id, T entity);
}
