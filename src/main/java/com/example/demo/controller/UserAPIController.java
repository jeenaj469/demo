package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserServices;
import com.example.demo.validation.Validator;

@RestController
@RequestMapping("/User")
public class UserAPIController {
	User user;
	Validator validator;
	List<User> l1;
	UserServices userServices;
	public UserAPIController(UserServices userServices) {
		this.userServices = userServices;
	}
	@GetMapping("{userName}/{password}")
public User getUserDetails(@PathVariable String userName, @PathVariable String password) {
		try {
			user=new User();
			user.setUserName(userName);
			user.setPassword(password);
		validator=new Validator();
	String result=	validator.validateUserNameAndPassword(user);
	user.setResult(result);
	if(user.getResult()!=null && user.getResult().equalsIgnoreCase("0")) {
		user=userServices.getUserDetails(userName, password);
	}
		}catch(Exception e) {
			e.printStackTrace();
		}
	return user;
}
	@PostMapping("/create")
	public String createUser(@RequestBody User user) {
		validator=new Validator();
		validator.validateAll(user);
		boolean isExist=userServices.isExist(user.getUserName(), user.getPassword());
		
		if(user.getResult()!=null && user.getResult().equalsIgnoreCase("0")) {
			if(!isExist) {
			userServices.createUser(user);
			return "user got created";
			}else {
				return "user already exist";
			}
			
		}else {
			return user.getResult();
		}
		
		
	}
	@PutMapping("/update/{username}")
	public String updateUser(@PathVariable String username,@RequestBody User user) {
		
		validator=new Validator();
		validator.validateAll(user);
		if(user.getResult()!=null && user.getResult().equalsIgnoreCase("0")) {
			userServices.updateUser(user);
			return "user got updated";
		}else {
			return user.getResult();
		}
		
	}
	@DeleteMapping("/delete/{username}")
	public String deleteUser(@PathVariable String username) {
		boolean isExistById=userServices.existsByUserName(username);
		if(isExistById) {
		userServices.deleteUser(username);
		return "user got deleted";
		}else {
			return "id doesn't exist";
		}
	}
	@GetMapping("/getAll")
	public List<User> getAllUserDetails() {
			try {
				user=new User();	
			 l1=userServices.getAllUser();
		
			}catch(Exception e) {
				e.printStackTrace();
			}
		return l1;
	}
}
