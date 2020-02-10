package com.dd.service;

import com.dd.model.Users;

public interface UsersService {
	public String registerChar(Users user) throws Exception;
	public String deleteChar(String charId) throws Exception;
	public Users getChar(String charId) throws Exception;
	public String modifyChar(Users user) throws Exception;
	public String lvlOneChar(Users user) throws Exception;
}
