package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="User_Info")
public class User {
	private String name;
	private String emailId;
    private String mobileNo;
    @javax.persistence.Id
    @Column(name = "userName")
    private String userName;
    private String password;
    private String result;
    public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public User(String name, String emailId, String mobileNo, String userName, String password) {
		this.name = name;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.userName = userName;
		this.password = password;
	}
	public User() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
