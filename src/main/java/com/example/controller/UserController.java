package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.repository.UserRepository;



@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	

	@RequestMapping("/saveUser")
	public String addUser() {
		
		String username = "Ces@1234";
		String password = "1234";
		String firstName = "Cesar";
		String lastName = "Danila";
		String email = "cesar@gmail.com";
		
		User user = new User(username, password, firstName, lastName, email); 
		
		userRepository.save(user);
		
		return "User is saved successfully";
	}
	
	@RequestMapping("/allUsers")
	public List<User> getAllUsers() {
		
		List<User> users = userRepository.findAll();
		
		return users;
	}
	
	@RequestMapping("/delete/{uid}")
	public String deleteUser(@PathVariable String uid) {
		
		userRepository.deleteById(uid);
		
		return "User Deleted Successfully";
	}
	
	
}
