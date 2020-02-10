package com.dd.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dd.dao.UsersDAO;
import com.dd.model.Users;
import com.dd.validator.Validator;

@Service("UserService")
@Transactional
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private UsersDAO usersDAO;
	
	//Create Character and add to the character_final_stats Table 
	@Override
	public String registerChar(Users user) throws Exception {
		//Validator.validate(user.getCharId());
		String result = usersDAO.registerChar(user);
		if(result.equals("Character was not added")){
			throw new Exception();
		} else{
			return result;
		}
	}
	
	//Delete Character from character_final_stats Table
	@Override
	public String deleteChar(String charId) throws Exception {
		//Validator.validate(charId);
		String result = usersDAO.deleteChar(charId);
		if(result.equals("Character was not deleted")) {
			throw new Exception();
		} else {
			return result;
		}
	}
	
	//Get Character from the character_final_stats Table
	@Override
	public Users getChar(String charId) throws Exception {
		Users user = usersDAO.getChar(charId);
		if(user == null) {
			throw new Exception();
		} else {
			return user;
		}
	}
	
	//Level up the character 
	@Override
	public String modifyChar(Users user) throws Exception {
		String result = usersDAO.modifyChar(user);
		if(result.equals("Character stats were not modified")) {
			throw new Exception();
		} else {
			return result;
		}
	}
	
	//Add Level One stats to the new Character
	@Override
	public String lvlOneChar(Users user) throws Exception {
		String result = usersDAO.lvlOneChar(user);
		if(result.equals("Character stats were not modified")) {
			throw new Exception();
		} else {
			return result;
		}
	}

}
