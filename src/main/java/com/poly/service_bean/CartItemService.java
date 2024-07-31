package com.poly.service_bean;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.poly.bean.CartItem;

public interface CartItemService {
	
	public List<CartItem> findByUser(int userID);
	
	public CartItem findById(Long id);
	
	public CartItem create(JsonNode CartItemData);
	
}
