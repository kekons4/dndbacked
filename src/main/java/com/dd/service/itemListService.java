package com.dd.service;

import com.dd.model.items;

public interface itemListService {
	public String addItem(items item) throws Exception;
	public String removeItem(String itemId) throws Exception;
}
