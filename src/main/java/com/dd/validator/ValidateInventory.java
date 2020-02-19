package com.dd.validator;

public class ValidateInventory {
	public static String validateInv(String invId) {
		if(!invId.startsWith("INV")) {
			return "ERROR the given inventory ID does not follow standard naming scheme.";
		} else {
			return "Success: naming scheme matches standards";
		}
	}
}
