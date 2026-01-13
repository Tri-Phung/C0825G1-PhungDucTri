package com.codegym.customermanagement.controller;

import com.codegym.customermanagement.entity.Customer;
import com.codegym.customermanagement.service.ICustomerService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    private final ICustomerService customerService;
    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping("")
    public String listCustomers(Model model){
        model.addAttribute("customers",customerService.findAll());
        return "customer/list";
    }
    @GetMapping("/add")
    public String addCustomer(Model model){
        model.addAttribute("customer",new Customer());
        return "customer/add";
    }
    @GetMapping("/{id}/edit")
    public String editCustomer(@PathVariable("id") Long id, Model model){
        model.addAttribute("customer",customerService.findById(id));
        return "customer/edit";
    }
    @PostMapping("/add")
    public String addCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "customer/add";
        }
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message","Customer added successfully");
        return "redirect:/customers";
    }
    @PostMapping("/edit")
    public String editCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "customer/edit";
        }
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message","Customer updated successfully");
        return "redirect:/customers";
    }
    @PostMapping("/{id}/delete")
    public String deleteCustomer(@PathVariable("id") Long id, RedirectAttributes redirectAttributes){
        customerService.delete(id);
        redirectAttributes.addFlashAttribute("message","Customer deleted successfully");
        return "redirect:/customers";
    }
}
