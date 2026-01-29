package com.codegym.customer_list.repository;

import com.codegym.customer_list.entity.Customer;

import java.util.LinkedList;

public class CustomerRepository {
    static LinkedList<Customer> customers = new LinkedList<>();
    static {
        customers.add(new Customer("Mai Văn Hoàn","1983-08-20","Hà Nội","https://cdn-icons-png.flaticon.com/512/5556/5556468.png"));
        customers.add(new Customer("Nguyễn Văn Nam","1983-08-21","Bắc Giang","https://cdn-icons-png.flaticon.com/512/5556/5556468.png"));
        customers.add(new Customer("Nguyễn Thái Hòa","1983-08-22","Nam Định","https://cdn-icons-png.flaticon.com/512/5556/5556468.png"));
        customers.add(new Customer("Trần Đăng Khoa","1983-08-17","Hà Tây","https://cdn-icons-png.flaticon.com/512/5556/5556468.png"));
        customers.add(new Customer("Nguyễn Đình Thi","1983-08-19","Hà Nội","https://cdn-icons-png.flaticon.com/512/5556/5556468.png"));

    }
    public LinkedList<Customer> getCustomers() {
        return customers;
    }
}
