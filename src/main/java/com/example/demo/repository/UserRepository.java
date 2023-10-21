package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User,String>{

	public User findByUserNameAndPassword(String userName, String password);

	public String deleteByUserName(String username);
	public boolean existsByUserNameAndPassword(String userName, String password);

	public boolean existsByUserName(String userName);
	
	
}
