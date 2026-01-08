package com.codegym.appbookborrowing.service;

import java.util.List;

public interface IService<T> {
    List<T> findAll();
    T findById(Long id);
    T save(T entity);
    boolean delete(Long id);
}
