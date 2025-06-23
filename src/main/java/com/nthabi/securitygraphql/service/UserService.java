package com.nthabi.securitygraphql.service;

import com.nthabi.securitygraphql.model.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService {

    @Autowired
    private InMemoryUserDetailsManager inMemoryUserDetailsManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    public void createUser(CustomUser user) {
        UserDetails userDetails = new User(user.getUsername(), passwordEncoder.encode(user.getPassword()), Collections.singleton(new SimpleGrantedAuthority("USER")));
        inMemoryUserDetailsManager.createUser(userDetails);
    }
}
