package com.example.sociallogindemo.controller;

import com.example.sociallogindemo.entity.Users;
import com.example.sociallogindemo.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @PostMapping(name = "/test")
    public UserDetails userLogin (@RequestBody Users user){

        return userDetailsService.loadUserByUsername(user.getUserName());
    }
}
