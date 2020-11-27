package com.example.demo.controller.rest;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserResource {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/allUsers")
    public List<User> allUsers() {
        return userService.getAllUsers();
    }

}
