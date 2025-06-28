package com.nthabi.securitygraphql.service;

import com.nthabi.securitygraphql.model.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService {

    private final InMemoryUserDetailsManager inMemoryUserDetailsManager;

    private final PasswordEncoder passwordEncoder;

    public UserService(InMemoryUserDetailsManager inMemoryUserDetailsManager, PasswordEncoder passwordEncoder) {
        this.inMemoryUserDetailsManager = inMemoryUserDetailsManager;
        this.passwordEncoder = passwordEncoder;
    }

    public void createUser(CustomUser user) {
        UserDetails userDetails = new User(user.getUsername(), passwordEncoder.encode(user.getPassword()), Collections.singleton(new SimpleGrantedAuthority(user.getRole())));
        inMemoryUserDetailsManager.createUser(userDetails);
    }

    public void updateUser(CustomUser user, CustomUser newUserDetails) {
        if (inMemoryUserDetailsManager.userExists(user.getUsername())) {
            UserDetails newUser = new User(user.getUsername(), passwordEncoder.encode(user.getPassword()), Collections.singleton(new SimpleGrantedAuthority(user.getRole())));
            inMemoryUserDetailsManager.updateUser(newUser);

        }
        throw new UsernameNotFoundException("User doesn't exist");
    }

}
