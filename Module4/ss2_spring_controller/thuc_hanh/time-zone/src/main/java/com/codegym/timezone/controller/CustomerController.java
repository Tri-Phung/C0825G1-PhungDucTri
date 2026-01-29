package com.codegym.timezone.controller;

import com.codegym.timezone.model.Customer;
import com.codegym.timezone.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("")
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("=/list");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView showDetail(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("info");
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return new ModelAndView("redirect:/customers");
        }
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }
    @PostMapping("/update")
    public String updateCustomer(Customer customer){
        customerService.save(customer);
        return "redirect:/customers";
    }
}
