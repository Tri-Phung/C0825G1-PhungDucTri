package com.codegym.customermanagement.service;

import com.codegym.customermanagement.entity.Customer;
import com.codegym.customermanagement.repository.CustomerRepository;
import jakarta.persistence.NoResultException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements ICustomerService{
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new NoResultException("Customer not found"));
    }

    @Override
    public Customer save(Customer entity) {
        return customerRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}
