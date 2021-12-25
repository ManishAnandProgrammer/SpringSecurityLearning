package com.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserDetailServiceConfiguration {

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager inMemoryUserDetailsManager =
                new InMemoryUserDetailsManager();

        UserDetails manish = User.withUsername("manish")
                .password("admin@123")
                .authorities("ADMIN")
                .build();

        UserDetails neeraj = User.withUsername("neeraj")
                .password("user@123")
                .authorities("USER")
                .build();

        inMemoryUserDetailsManager.createUser(manish);
        inMemoryUserDetailsManager.createUser(neeraj);

        return inMemoryUserDetailsManager;
    }
}
