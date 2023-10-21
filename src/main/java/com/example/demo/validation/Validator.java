package com.example.demo.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.demo.model.User;

public class Validator {

	public String validateAll(User user) {
		try {
			user.setResult("0");
			int length=10;
			if((user.getResult()!=null && user.getResult().equalsIgnoreCase("0")) && user.getEmailId()==null ||user.getEmailId().trim().equalsIgnoreCase("")||  !user.getEmailId().contains("@gmail.com")) {
				user.setResult("Invalid EmailId"); 
			}
			if((user.getResult()!=null && user.getResult().equalsIgnoreCase("0")) && user.getName()!=null) {
				Pattern p=Pattern.compile("[A-Za-z\\s]+");
				Matcher m=p.matcher(user.getName());
				if(m.find()) {
					user.setResult("0"); 
				}else {
					user.setResult("Please enter a valid name which don't allow special characters");
				}
				}
			if((user.getResult()!=null && user.getResult().equalsIgnoreCase("0")) &&user.getName()==null) {
				user.setResult("pls enter the name");
			}
			if((user.getResult()!=null && user.getResult().equalsIgnoreCase("0")) && user.getMobileNo()!=null && user.getMobileNo().length()==length) {
				Pattern p=Pattern.compile("^[^0][0-9]+$");
				Matcher m=p.matcher(user.getMobileNo());
				if(m.find()) {
					user.setResult("0");
				}else {
					user.setResult("Please enter a valid mobileNo");
				}
			}if((user.getResult()!=null && user.getResult().equalsIgnoreCase("0")) && user.getMobileNo()==null|| user.getMobileNo().length()!=length) {
				user.setResult("pls enter the mobileNo properly");
			}
			 length=10;
			if((user.getResult()!=null && user.getResult().equalsIgnoreCase("0")) && user.getUserName()!=null && !user.getUserName().trim().equalsIgnoreCase("") && user.getUserName().length()==length) {
				if(user.getPassword()!=null && !user.getPassword().trim().equalsIgnoreCase("") && user.getPassword().length()==length) {
					user.setResult("0");
				}else {
					user.setResult("Please enter a valid password");
				}
			}if((user.getResult()!=null && user.getResult().equalsIgnoreCase("0")) && user.getUserName()==null || user.getUserName().trim().equalsIgnoreCase("") ||  user.getUserName().length()!=length) {
				user.setResult("Please enter a valid userName");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		return user.getResult();
	}
	public String validateName(User user) {
		try {
			if(user.getName()!=null) {
			Pattern p=Pattern.compile("[A-Za-z\\s]+");
			Matcher m=p.matcher(user.getName());
			if(m.find()) {
				return "0";
			}else {
				return "Please enter a valid name which don't allow special characters";
			}
			}else {
				return "pls enter the name";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		return "0";
	}
	public String validateMobileNo(User user) {
		try {
			int length=10;
			if(user.getMobileNo()!=null && user.getMobileNo().length()==length) {
				Pattern p=Pattern.compile("[1-9][0-9]+");
				Matcher m=p.matcher(user.getMobileNo());
				if(m.find()) {
					return "0";
				}else {
					return "Please enter a valid mobileNo";
				}
			}else{
				return "pls enter the mobileNo";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		return "0";
	}
	public String validateUserNameAndPassword(User user) {
		
		try {
			int length=10;
			if(user.getUserName()!=null && !user.getUserName().trim().equalsIgnoreCase("") && user.getUserName().length()==length) {
				if(user.getPassword()!=null && !user.getPassword().trim().equalsIgnoreCase("") && user.getPassword().length()==length) {
					return "0";
				}else {
					return "Please enter a valid password";
				}
			} else {
				return "Please enter a valid userName";
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		return "0";
	}


}
