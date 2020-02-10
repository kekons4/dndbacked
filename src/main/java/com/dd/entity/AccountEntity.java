package com.dd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "acct")
public class AccountEntity {
	
	@Id
	@Column(name = "email_id")
	private String emailId;
	private String username;
	private String password;
	@Column(name = "char_id_one")
	private String charIdOne;
	@Column(name = "char_id_two")
	private String charIdTwo;
	@Column(name = "char_id_three")
	private String charIdThree;
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCharIdOne() {
		return charIdOne;
	}
	public void setCharIdOne(String charIdOne) {
		this.charIdOne = charIdOne;
	}
	public String getCharIdTwo() {
		return charIdTwo;
	}
	public void setCharIdTwo(String charIdTwo) {
		this.charIdTwo = charIdTwo;
	}
	public String getCharIdThree() {
		return charIdThree;
	}
	public void setCharIdThree(String charIdThree) {
		this.charIdThree = charIdThree;
	}
	
	
}
