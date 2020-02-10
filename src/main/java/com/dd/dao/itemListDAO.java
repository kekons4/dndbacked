package com.dd.dao;

import com.dd.model.items;

public interface itemListDAO {
	public String addItem(items item) throws Exception;
	public String removeItem(String itemId) throws Exception;
}
