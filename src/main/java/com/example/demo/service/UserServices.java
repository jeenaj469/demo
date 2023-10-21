package com.example.demo.service;

import java.util.List;



import com.example.demo.model.User;

public interface UserServices {
	public User getUserDetails(String userName,String password) ;
	public String createUser( User user);
	public String updateUser(User user);
	public String deleteUser(String userName);
	public List<User> getAllUser();
	public boolean isExist(String userName,String password);
	public boolean existsByUserName(String userName);
	
}
