package com.dd.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.dd.model.Account;
import com.dd.service.AccountService;

@CrossOrigin
@RestController
@RequestMapping("account")
public class acctAPI {
	
	@Autowired
	private AccountService as;
	
	//Login API Call: Accepts Account object
	@PostMapping(value = "login")
	public ResponseEntity<String[]> login(@RequestBody Account acct) throws Exception{
		try {
			String msg = as.login(acct);
			String[] txt  = new String[1];
			txt[0] = msg;
			return new ResponseEntity<String[]>(txt, HttpStatus.OK);
		} catch(Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	//Register API Call: Accepts Account object
	@PostMapping(value = "register")
	public ResponseEntity<String[]> register(@RequestBody Account acct) throws Exception {
		try {
			String msg = as.register(acct);
			String[] txt = new String[1];
			txt[0] = msg;
			return new ResponseEntity<String[]>(txt, HttpStatus.OK);
		} catch(Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	//Add Character API Call: path variable is email and Accepts character id
	@PostMapping(value = "addCharacter/{emailId}")
	public ResponseEntity<String[]> addCharacter(@PathVariable String emailId, @RequestBody String charId) throws Exception{
		try {
			String msg = as.addCharacter(emailId, charId);
			String[] txt = new String[1];
			txt[0] = msg;
			return new ResponseEntity<String[]>(txt, HttpStatus.OK);
		} catch(Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	//Delete Character API call: path variable is email id and Accepts character id
	@PostMapping(value = "removeCharacter/{emailId}")
	public ResponseEntity<String[]> removeCharacter(@PathVariable String emailId, @RequestBody String charId) throws Exception{
		try {
			String msg = as.removeCharacter(emailId, charId);
			String[] txt = new String[1];
			txt[0] = msg;
			return new ResponseEntity<String[]>(txt, HttpStatus.OK);
		} catch(Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
}
