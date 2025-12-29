package com.codegym.springformtutorial.controller;

import com.codegym.springformtutorial.model.Login;
import com.codegym.springformtutorial.model.User;
import com.codegym.springformtutorial.repository.UserDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController {
    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("user/home");
        modelAndView.addObject("login",new Login());
        return modelAndView;
    }
    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("login") Login login){
        User user = UserDAO.checkLogin(login);
        ModelAndView modelAndView;
        if(user == null){
            modelAndView = new ModelAndView("user/error");
        }else{
            modelAndView = new ModelAndView("user/user");
            modelAndView.addObject("user",user);
        }
        return modelAndView;
    }
}
