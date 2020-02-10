package com.dd.dao;

import com.dd.model.invItem;
import com.dd.model.inventory;

public interface InventoryDAO {
	public inventory getInventory(String invId) throws Exception;
	public String addItem(String invId, invItem item) throws Exception;
	public String removeItem(String itemId, String invId) throws Exception;
}
