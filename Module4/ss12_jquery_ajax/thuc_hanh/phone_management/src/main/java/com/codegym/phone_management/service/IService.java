package com.codegym.phone_management.service;

import com.codegym.phone_management.entity.Smartphone;

import java.util.List;

public interface IService {
    List<Smartphone> findAll();
    Smartphone findById(Long id);
    Smartphone save(Smartphone entity);
    void deleteById(Long id);
}
