package com.dd.service;

import javax.transaction.Transactional;
import com.dd.validator.ValidateInventory;
import com.dd.validator.ValidateItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dd.dao.InventoryDAO;
import com.dd.model.invItem;
import com.dd.model.inventory;

@Service("InventoryService")
@Transactional
public class InventoryServiceImpl implements InventoryService {
	
	@Autowired
	InventoryDAO invD;
	
	//Get the Inventory of the character: Validate if inventory id is properly formatted
	@Override
	public inventory getInventory(String invId) throws Exception {
		try {
			if (ValidateInventory.validateInv(invId).startsWith("ERROR")) {
				throw new Exception("ERROR the given inventory ID does not follow standard naming scheme.");
			} 
		} catch(Exception e) {
			e.printStackTrace();
		}
		inventory inv = invD.getInventory(invId);
		return inv;
	}
	
	//Add item to character inventory: Validate if inventory id and item id are properly formatted
	@Override
	public String addItem(String invId, invItem item) throws Exception {
		try {
			if (ValidateInventory.validateInv(invId).startsWith("ERROR")) {
				throw new Exception("ERROR the given inventory ID does not follow standard naming scheme.");
			}
			
			if (ValidateItem.itemValidate(item.getItemId()).startsWith("ERROR")) {
				throw new Exception("ERROR in validation");
			}
		} catch(Exception e) {
			return e.getMessage();
		}
		String result = invD.addItem(invId, item);
		return result;
	}
	
	//Remove item from character inventory: Validate whether item id and inventory id are properly formatted
	@Override
	public String removeItem(String itemId, String invId) throws Exception {
		try {
			if (ValidateInventory.validateInv(invId).startsWith("ERROR")) {
				throw new Exception("ERROR the given inventory ID does not follow standard naming scheme.");
			}
			
			if (ValidateItem.itemValidate(itemId).startsWith("ERROR")) {
				throw new Exception("ERROR in validation");
			}
		} catch(Exception e) {
			return e.getMessage();
		}
		String result = invD.removeItem(itemId, invId);
		return result;
	}

}
