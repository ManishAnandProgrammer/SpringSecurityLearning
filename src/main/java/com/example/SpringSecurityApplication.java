package com.example;

import com.example.domain.User;
import com.example.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringSecurityApplication {

	//private final UserService userService;

//	public SpringSecurityApplication(UserService userService) {
//		this.userService = userService;
//	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void createDefaultUser() {
//		User user = new User();
//		user.setUsername("manish");
//		user.setPassword("admin");
//
//		userService.registerUser(user);
	}

}
