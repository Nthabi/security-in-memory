package com.nthabi.securitygraphql.controller;

import com.nthabi.securitygraphql.model.CustomUser;
import com.nthabi.securitygraphql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    private UserService userService;

    @GetMapping("/")
    public String welcome(){
        return "Welcome to the dashboard!";
    }

    @GetMapping("/stats")
    public String stats() {
        return "These are the stats";
    }

    @PostMapping("/new")
    public ResponseEntity<String> createUser(@RequestBody CustomUser user){
        userService.createUser(user);
        return ResponseEntity.ok("User created");
    }
}
