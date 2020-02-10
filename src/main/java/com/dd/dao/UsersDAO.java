package com.dd.dao;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import com.dd.model.Users;

public interface UsersDAO {
	public String registerChar(Users user);
	public String deleteChar(String charId);
	public Users getChar(String charId);
	public String modifyChar(Users user);
	public String lvlOneChar(Users user);
}
