package com.dd.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.dd.model.items;
import com.dd.service.UsersService;
import com.dd.service.itemListService;

@CrossOrigin
@RestController
@RequestMapping("configure")
public class itemAPI {
	
	@Autowired
	private UsersService us;
	
	@Autowired
	private itemListService ils;
	
	//Add item API call: Accepts items object in Body
	@PostMapping(value = "addItem")
	public ResponseEntity<String[]> addItem(@RequestBody items item) throws Exception{
		try {
			String msg = ils.addItem(item);
			String[] txt = new String[1];
			txt[0] = msg;
			return new ResponseEntity<String[]>(txt, HttpStatus.OK);
		}catch(Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	//Remove item API call: Accepts item id in Body
	@GetMapping(value = "removeItem")
	public ResponseEntity<String[]> removeItem(@RequestBody String itemId) throws Exception{
		try {
			String msg = ils.removeItem(itemId);
			String[] txt = new String[1];
			txt[0] = msg;
			return new ResponseEntity<String[]>(txt, HttpStatus.OK);
		}catch(Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
}
