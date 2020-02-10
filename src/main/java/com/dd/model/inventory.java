package com.dd.model;

import java.util.ArrayList;

public class inventory {
	private ArrayList<invItem> inventory = new ArrayList<invItem>();

	public ArrayList<invItem> getInventory() {
		return inventory;
	}

	public void addItem(invItem item) {
		this.inventory.add(item);
	}
	
	public String removeItem(String itemId) {
		for(int i = 0; i <= this.inventory.size(); i ++) {
			if(this.inventory.get(i).getItemId().equals(itemId)) {
				this.inventory.remove(i);
				return "Item succesfully removed";
			}
		}
		return "Error could not find Item in inventory...";
	}
}
