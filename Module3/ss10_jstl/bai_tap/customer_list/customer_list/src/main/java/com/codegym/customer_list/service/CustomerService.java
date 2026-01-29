package com.codegym.customer_list.service;

import com.codegym.customer_list.entity.Customer;
import com.codegym.customer_list.repository.CustomerRepository;

import java.util.List;

public class CustomerService implements ICustomerService {
    private final CustomerRepository repository = new CustomerRepository();
    @Override
    public List<Customer> findAll() {
        return repository.getCustomers();
    }

    @Override
    public Customer findById(Long id) {
        return null;
    }

    @Override
    public boolean save(Customer customer) {
        return false;
    }

    @Override
    public boolean update(Customer customer) {
        return false;
    }

    @Override
    public void delete(Long id) {

    }
}
