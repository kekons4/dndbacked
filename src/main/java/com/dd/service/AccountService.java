package com.dd.service;

import com.dd.model.Account;

public interface AccountService {
	public String login(Account acct);
	public String register(Account acct);
	public String addCharacter(String emailId, String charId);
	public String removeCharacter(String emailId, String charId);
}
