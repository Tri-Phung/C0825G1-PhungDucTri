package practice_module2.service;

import practice_module2.common.exception.CustomerCodeDuplicatedException;
import practice_module2.entity.Customer;
import practice_module2.repository.CustomerRepository;

import java.util.List;

public class CustomerService implements ICustomerService<Customer>{
    private final CustomerRepository customerRepository = new CustomerRepository();
    @Override
    public List<Customer> findCustomerByName(String name) {
        return customerRepository.findCustomerByName(name);
    }

    @Override
    public boolean checkDuplicateCustomerCode(String customerCode) throws CustomerCodeDuplicatedException {
        List<Customer> customers = customerRepository.findAllCustomer();
        for (Customer customer : customers) {
            if (customer.getCustomerCode().equals(customerCode)) {
                throw new CustomerCodeDuplicatedException("Customer code is duplicated. Please try another one");
            }
        }
        return false;
    }

    @Override
    public void add(Customer customer) {
        customerRepository.addCustomer(customer);
    }

    @Override
    public List<Customer> displayInfo() {
        return customerRepository.findAllCustomer();
    }
}
