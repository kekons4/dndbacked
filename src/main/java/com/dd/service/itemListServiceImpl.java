package com.dd.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dd.dao.itemListDAO;
import com.dd.model.items;
import com.dd.validator.ValidateItem;

@Service("itemListService")
@Transactional
public class itemListServiceImpl implements itemListService{
	
	@Autowired
	itemListDAO ild;
	
	//Add item to the List of All items
	@Override
	public String addItem(items item) throws Exception {
		String validate = ValidateItem.itemValidate(item.getItemId());
		if(validate.equals("ERROR in validation")) {
			throw new Exception("ITEM.ERROR_VALIDATION");
		} else {
			String msg = ild.addItem(item);
			return msg;
		}
	}
	
	// Remove item from the List of all items
	@Override
	public String removeItem(String itemId) throws Exception {
		String validate = ValidateItem.itemValidate(itemId);
		if(validate.equals("ERROR in validation")) {
			throw new Exception("ITEM.ERROR_VALIDATION");
		} else {
			String msg = ild.removeItem(itemId);
			return msg;
		}
	}
}
