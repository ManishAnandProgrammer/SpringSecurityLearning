package com.example.security;

import com.example.repository.UserRepository;
import com.example.service.UserDetailsManagerImplementation;
import com.example.service.UserDetailsServiceImplementation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
public class UserDetailServiceConfiguration {

//    @Bean
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager inMemoryUserDetailsManager =
//                new InMemoryUserDetailsManager();
//
//        UserDetails manish = User.withUsername("manish")
//                .password("admin@123")
//                .authorities("ADMIN")
//                .build();
//
//        UserDetails neeraj = User.withUsername("neeraj")
//                .password("user@123")
//                .authorities("USER")
//                .build();
//
//        inMemoryUserDetailsManager.createUser(manish);
//        inMemoryUserDetailsManager.createUser(neeraj);
//
//        return inMemoryUserDetailsManager;
//    }

//    @Bean
//    public UserDetailsService userDetailsService(UserRepository userRepository) {
//        return new UserDetailsServiceImplementation(userRepository);
//    }

    @Bean
    public UserDetailsManager userDetailsManager(UserRepository userRepository,
                                                 PasswordEncoder passwordEncoder) {
        return new UserDetailsManagerImplementation(userRepository, passwordEncoder);
    }
}
