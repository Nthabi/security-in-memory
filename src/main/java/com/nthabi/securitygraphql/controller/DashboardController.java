package com.nthabi.securitygraphql.controller;

import com.nthabi.securitygraphql.model.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class DashboardController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    InMemoryUserDetailsManager inMemoryUserDetailsManager;

    @GetMapping("/")
    public String welcome(){
        return "Welcome to the dashboard!";
    }

    @GetMapping("/stats")
    public String stats() {
        return "These are the stats";
    }

    @PostMapping("/new")
    public String createUser(@RequestBody CustomUser user){
        UserDetails userDetails = new User(user.getUsername(), passwordEncoder.encode(user.getPassword()), Collections.singleton(new SimpleGrantedAuthority("USER")));
        inMemoryUserDetailsManager.createUser(userDetails);
        return "User created!";
    }
}
