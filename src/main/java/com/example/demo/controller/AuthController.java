package com.example.demo.controller;

import com.example.demo.controller.errors.UserAlreadyExistException;
import com.example.demo.service.UserPrincipalService;
import com.example.demo.service.dto.UserDto;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/")
public class AuthController {
    
    private Logger logger = LoggerFactory.getLogger(AuthController.class);
    
    @Autowired
    private UserPrincipalService userPrincipalService;
    
    @GetMapping("/login")
    public String showLoginForm() {
        return "login-form";
    }
    
    @GetMapping("/registration")
    public String showRegisterationFrom(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registration-form";
    }
    
    @PostMapping("/registration")
    public String registerAccount(@ModelAttribute("user") @Valid UserDto userDto, BindingResult bindingResult) throws UserAlreadyExistException {
        
        logger.info("I'm here");
        
        if (bindingResult.hasErrors()) {
            return "redirect:/registration";
        }
        
        userPrincipalService.registerNewUserAccount(userDto);
        
        return "success-register";
    }

}
