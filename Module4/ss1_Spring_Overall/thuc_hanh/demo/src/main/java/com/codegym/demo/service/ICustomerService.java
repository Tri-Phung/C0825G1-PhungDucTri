package com.codegym.demo.service;

import com.codegym.demo.entity.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Customer findById(int id);
}
