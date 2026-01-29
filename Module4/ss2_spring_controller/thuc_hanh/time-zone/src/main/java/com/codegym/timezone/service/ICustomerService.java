package com.codegym.timezone.service;

import com.codegym.timezone.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Customer findById(int id);
    void save(Customer customer);
}
