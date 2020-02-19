package com.dd.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dd.dao.AccountDAO;
import com.dd.model.Account;
import com.dd.validator.Validator;

@Service("AccountService")
@Transactional
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountDAO ad;
	
	//Login: Validate that email is properly formated
	@Override
	public String login(Account acct) {
		try {
			Validator.validate(acct.getEmailId());
		} catch (Exception e) {
			return e.getMessage();
		}
		String msg = ad.login(acct);
		return msg;
	}
	
	//Register new account: Validate that email is properly formatted
	@Override
	public String register(Account acct) {
		try {
			Validator.validate(acct.getEmailId());
		} catch (Exception e) {
			return e.getMessage();
		}
		String msg = ad.register(acct);
		return msg;
	}
	
	//Create new Character: Validate whether the email and character id is properly formatted
	@Override
	public String addCharacter(String emailId, String charId) {
		try {
			Validator.validate(emailId);
		} catch (Exception e) {
			return e.getMessage();
		}
		String msg = ad.addCharacter(emailId, charId);
		return msg;
	}
	
	
	//Delete Character: Validate whether the email and character id is properly formatted.
	@Override
	public String removeCharacter(String emailId, String charId) {
		try {
			Validator.validate(emailId);
		} catch (Exception e) {
			return e.getMessage();
		}
		String msg = ad.removeCharacter(emailId, charId);
		return msg;
	}
}
