package com.example.controller;

import com.example.domain.MyCustomUserDetails;
import com.example.domain.User;
import com.example.service.UserService;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private final UserService userService;
    private final UserDetailsManager userDetailsManager;

    public HomeController(UserService userService, UserDetailsManager userDetailsManager) {
        this.userService = userService;
        this.userDetailsManager = userDetailsManager;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring Security";
    }

    @PostMapping("/register")
    public void registerUser(@RequestBody User user) {
        userDetailsManager.createUser(new MyCustomUserDetails(user));
    }
}
