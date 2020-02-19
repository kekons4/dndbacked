package com.dd.API;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.server.ResponseStatusException;

import com.dd.model.Users;
import com.dd.model.invItem;
import com.dd.model.inventory;
import com.dd.service.InventoryService;
import com.dd.service.UsersService;
import com.dd.dao.TableCreate;
import com.fasterxml.jackson.databind.util.JSONPObject;

@CrossOrigin
@RestController
@RequestMapping("characters")
public class api {
	
	@Autowired
	private UsersService us;
	
	@Autowired
	private InventoryService invService;
	
	//A Test API call
	@GetMapping(value = "tester")
	public ResponseEntity<String[]> tester() throws Exception {
		String[] msg = new String[1];
		msg[0] = "Testing SSL";
		return new ResponseEntity<String[]>(msg, HttpStatus.OK);
	}
	
	//Another Test API Call
	@PostMapping(value = "test")
	public ResponseEntity<invItem> test(@RequestBody invItem test) throws Exception{
		try{
			return new ResponseEntity<invItem>(test, HttpStatus.OK);
		}
		catch(Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	//Adds Character API Call
	@PostMapping(value = "addCharacter")
	public ResponseEntity<String[]> addCharacter(@RequestBody Users users) throws Exception{
		try{
			String msg = us.registerChar(users);
			String[] txt = new String[1];
			txt[0] = msg;
			return new ResponseEntity<String[]>(txt, HttpStatus.OK);
		} catch(Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	//Deletes Character API call
	@PostMapping(value = "deleteCharacter")
	public ResponseEntity<String[]> deleteCharacter(@RequestBody String charId) throws Exception{
		try {
			String msg = us.deleteChar(charId);
			String[] txt = new String[1];
			txt[0] = msg;
			return new ResponseEntity<String[]>(txt, HttpStatus.OK);
		} catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	//Fetches Character stats
	@GetMapping(value = "getCharacter/{charId}")
	public ResponseEntity<Users> getCharacter(@PathVariable String charId) throws Exception{
		try {
			Users user = us.getChar(charId);
			return new ResponseEntity<Users>(user, HttpStatus.OK);
		} catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	//Levels up Character Stats
	@PostMapping(value = "lvlUpCharacter")
	public ResponseEntity<String[]> lvlUpCharacter(@RequestBody Users user) throws Exception{
		try {
			String msg = us.modifyChar(user);
			String[] txt = new String[1];
			txt[0] = msg;
			return new ResponseEntity<String[]>(txt, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	//Level One points for Character
	@PostMapping(value = "lvlOneCharacter")
	public ResponseEntity<String[]> lvlOneCharacter(@RequestBody Users user) throws Exception{
		try {
			String msg = us.lvlOneChar(user);
			String[] txt = new String[1];
			txt[0] = msg;
			return new ResponseEntity<String[]>(txt, HttpStatus.OK);
		} catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	//Fetch Character Inventory
	@GetMapping(value = "getInventory")
	public ResponseEntity<inventory> getInventory(@RequestBody String invId){
		try {
			inventory inv = invService.getInventory(invId);
			return new ResponseEntity<inventory>(inv, HttpStatus.OK);
		} catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	//Add item to Characters Inventory
	@PostMapping(value = "addItem/{invId}")
	public ResponseEntity<String[]> addItem(@PathVariable String invId, @RequestBody invItem item) throws Exception{
		try {
			String msg = invService.addItem(invId, item);
			String[] txt = new String[1];
			txt[0] = msg;
			return new ResponseEntity<String[]>(txt, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	//Remove item from Characters Inventory
	@PostMapping(value = "removeItem/{invId}")
	public ResponseEntity<String[]> removeItem(@PathVariable String invId, @RequestBody String itemId) throws Exception{
		try {
			String msg = invService.removeItem(itemId, invId);
			String[] txt = new String[1];
			txt[0] = msg;
			return new ResponseEntity<String[]>(txt, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
}
