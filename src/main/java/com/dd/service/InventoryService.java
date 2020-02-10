package com.dd.service;

import com.dd.model.invItem;
import com.dd.model.inventory;

public interface InventoryService {
	public inventory getInventory(String invId) throws Exception;
	public String addItem(String invItem, invItem item) throws Exception;
	public String removeItem(String itemId, String invId) throws Exception;
}
