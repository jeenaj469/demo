package com.example.demo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserServices;
@Service
public class UserServiceImplement implements UserServices {
	UserRepository userRepository;
	@Override
	public boolean isExist(String userName, String password) {
		// TODO Auto-generated method stub
		return userRepository.existsByUserNameAndPassword(userName, password);
	}

	
	@Override
	public boolean existsByUserName(String username) {
		// TODO Auto-generated method stub
		return userRepository.existsByUserName( username);
	}


	@Autowired
	public UserServiceImplement(UserRepository userRepository) {
	
	this.userRepository = userRepository;
}

	@Override
	public User getUserDetails(String userName, String password) {
		// TODO Auto-generated method stub
		
		return userRepository.findByUserNameAndPassword(userName,password);
	}
	
	
	@Override
	public String createUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
		return "user got created";
	}

	@Override
	public String updateUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
		
		return "user got updated";
	}
	@Transactional
	@Override
	public String deleteUser(String username) {
		userRepository.deleteByUserName(username);
		// TODO Auto-generated method stub
		return "deleted the entry";
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		
		return userRepository.findAll();
	}
	

}
