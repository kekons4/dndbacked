package com.dd.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dd.entity.AccountEntity;
import com.dd.entity.UserEntity;
import com.dd.model.Account;

@Repository("AccountDAO")
public class AccountDAOImpl implements AccountDAO{
	
	@Autowired
	private EntityManager em;
	
	
	// Login
	@Override
	public String login(Account acct) {
		AccountEntity check = em.find(AccountEntity.class, acct.getEmailId());
		if(check != null) {
			if(acct.getPassword().equals(check.getPassword())) {
				return "Login Successful";
			} else {
				return "Login Failed either incorrect email and password or account does not exist";
			}
		}else {
			return "Login Failed either incorrect email and password or account does not exist";
		}
	}
	
	
	//Register
	@Override
	public String register(Account acct) {
		AccountEntity check = em.find(AccountEntity.class, acct.getEmailId());
		if(check == null) {
			AccountEntity register = new AccountEntity();
			register.setEmailId(acct.getEmailId());
			register.setUsername(acct.getUsername());
			register.setPassword(acct.getPassword());
			register.setCharIdOne(acct.getCharIdOne());
			register.setCharIdTwo(acct.getCharIdTwo());
			register.setCharIdThree(acct.getCharIdThree());
			
			em.persist(register);
			return "Account has been registered";
		} else {
			return "ERROR Account already exists...";
		}
	}
	
	
	//Add Character to account
	@Override
	public String addCharacter(String emailId, String charId) {
		AccountEntity check = em.find(AccountEntity.class, emailId);
		if(check != null) {
			if(check.getCharIdOne() == null) {
				check.setCharIdOne(charId);
				em.persist(check);
				return "Successfully add character to account";
			} else if(check.getCharIdTwo() == null) {
				check.setCharIdTwo(charId);
				em.persist(check);
				return "Successfully add character to account";
			} else if(check.getCharIdThree() == null) {
				check.setCharIdThree(charId);
				em.persist(check);
				return "Successfully add character to account";
			} else {
				return "ERROR all three character slots have been filled, cannot create another character...";
			}
		} else {
			return "ERROR the following Account does not exist...";
		}
	}
	
	
	//Remove Character from account
	@Override
	public String removeCharacter(String emailId, String charId) {
		AccountEntity check = em.find(AccountEntity.class, emailId);
		UserEntity ue = em.find(UserEntity.class, charId);
		
		if(check != null) {
			if(check.getCharIdOne().equals(charId)) {
				check.setCharIdOne(null);
				em.persist(check);
				
				if(ue != null) {
					em.remove(ue);
					return "Successfully removed the character from Account and DB";
				} else {
					return "Successfully removed the character from Account";
				}
				
			} else if(check.getCharIdTwo().equals(charId)) {
				check.setCharIdTwo(null);
				em.persist(check);
				
				if(ue != null) {
					em.remove(ue);
					return "Successfully removed the character from Account and DB";
				} else {
					return "Successfully removed the character from Account";
				}
				
			} else if(check.getCharIdThree().equals(charId)) {
				check.setCharIdThree(null);
				em.persist(check);
				
				if(ue != null) {
					em.remove(ue);
					return "Successfully removed the character from Account and DB";
				} else {
					return "Successfully removed the character from Account";
				}
				
			} else {
				return "ERROR the following character does not exist in the account...";
			}
		} else {
			return "ERROR the following Account does not exist...";
		}
	}

}
