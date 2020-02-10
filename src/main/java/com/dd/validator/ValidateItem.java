package com.dd.validator;

public class ValidateItem {
	
	public static String itemValidate(String itemId) {
		if(!itemId.startsWith("item")){
			return "ERROR in validation";
		} else {
			return "Success in validation";
		}
	}
}
