package com.codegym.validateformregister.controller;

import com.codegym.validateformregister.common.validator.UniqueEmailValidator;
import com.codegym.validateformregister.common.validator.UserValidate;
import com.codegym.validateformregister.entity.User;
import com.codegym.validateformregister.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/register")
    public String showRegisterForm(Model model){
        model.addAttribute("user",new User());
        return "user/register";
    }
    @GetMapping("/welcome")
    public String welcome(){
        return "user/welcome";
    }
    @PostMapping("/register")
    public String register(@Validated @ModelAttribute("user") User user, BindingResult result, Model model){
        new UserValidate().validate(user, result);
        if(result.hasErrors()){
            return "user/register";
        }
        userService.save(user);
        return "redirect:/users/welcome";
    }

}
