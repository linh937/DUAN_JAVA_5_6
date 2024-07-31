package com.poly.service_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poly.bean.CartItem;
import com.poly.dao.CartItemDAO;
import com.poly.service_bean.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService{

	@Autowired
	CartItemDAO dao;
	
	@Override
	public List<CartItem> findByUser(int userID) {
		return dao.findAllBySQL(userID);
	}

	@Override
	public CartItem findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartItem create(JsonNode CartItemData) {
		ObjectMapper mapper = new ObjectMapper();

		CartItem CartItem = mapper.convertValue(CartItemData, CartItem.class);
		return dao.save(CartItem);
	}

}
