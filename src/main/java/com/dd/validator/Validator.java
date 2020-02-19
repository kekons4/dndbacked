package com.dd.validator;

import com.dd.model.Users;

public class Validator {
	public static void validate(String emailId) throws Exception{
		if(!validateEmailId(emailId)){
			throw new Exception("Validator.USER_NOT_FOUND");
		}
	}
	
	public static Boolean validateEmailId(String emailId){
		if(emailId.length() >= 8 && emailId.contains("@")){
			if(emailId.endsWith(".com") || emailId.endsWith(".net") || emailId.endsWith(".org") || emailId.endsWith(".edu")) {
				return true;
			} else {
				return false;
			}
		} else{
			return false;
		}
	}
}
