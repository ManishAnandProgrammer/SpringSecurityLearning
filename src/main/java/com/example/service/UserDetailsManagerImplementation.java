package com.example.service;

import com.example.domain.MyCustomUserDetails;
import com.example.domain.User;
import com.example.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;

import java.util.Optional;

public class UserDetailsManagerImplementation implements UserDetailsManager {

    private static final String USER_NOT_FOUND_MSG = "User not found with Given username %s";
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserDetailsManagerImplementation(UserRepository userRepository,
                                            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> mayBeUser = userRepository.findByUsername(username);
        User user = mayBeUser.orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, username)));
        return new MyCustomUserDetails(user);
    }

    @Override
    public void createUser(UserDetails user) {
        MyCustomUserDetails myCustomUserDetails = (MyCustomUserDetails) user;
        User myUser = myCustomUserDetails.getUser();
        myUser.setPassword(passwordEncoder.encode(myCustomUserDetails.getPassword()));
        userRepository.save(myUser);
    }

    @Override
    public void updateUser(UserDetails user) {
        // not implemented yet
        throw new UnsupportedOperationException("Not Implemented Yet..!");
    }

    @Override
    public void deleteUser(String username) {
        if (userExists(username)) {
            userRepository.deleteByUsername(username);
        } else {
            throw new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, username));
        }
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        // not implemented yet
        throw new UnsupportedOperationException("Not Implemented Yet..!");
    }

    @Override
    public boolean userExists(String username) {
        return userRepository.existsByUsername(username);
    }
}
