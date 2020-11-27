package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@SpringBootApplication
public class DatabaseApplication implements CommandLineRunner {

	@Autowired
	UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(DatabaseApplication.class, args);		
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		
		User u1 = userService.getUserWithId(355);
		System.out.println("user 1 info === " +u1.toString());
		
		User u2 = userService.getUserWithEmail("fbidwell5w@fda.gov");
		System.out.println("user 2 info === " +u2.toString());

		User u3 = userService.getUserWithFirstname("Claudio");
		System.out.println("user 3 info === " +u3.toString());
		
		List<User> users = userService.getAllUsers();
		users.forEach(user -> System.out.println("user info === " +user.toString()));
	}

}
