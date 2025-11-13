package practice_module2.controller;

import practice_module2.common.exception.CustomerCodeDuplicatedException;
import practice_module2.entity.Customer;
import practice_module2.service.CustomerService;
import practice_module2.service.ICustomerService;

import java.util.List;

public class CustomerController {
    ICustomerService<Customer> customerService = new CustomerService();
    public List<Customer> findCustomerByName(String name){
        return customerService.findCustomerByName(name);
    }
    public void addCustomer(Customer customer){
        customerService.add(customer);
    }
    public List<Customer> displayInfo(){
        return customerService.displayInfo();
    }
    public boolean checkDuplicatedCustomerCode(String customerCode) throws CustomerCodeDuplicatedException {
        return customerService.checkDuplicateCustomerCode(customerCode);
    }
}
