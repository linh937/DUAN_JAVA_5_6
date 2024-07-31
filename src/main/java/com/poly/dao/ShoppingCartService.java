package com.poly.dao;

import java.util.Collection;

import com.poly.bean.CartItem;

public interface ShoppingCartService {
//	List<CartItem> getItems();
	void add(int id);
	void remove(int id);
	void update(int id, int qty);
	void clear();
	int getCount();
	double getAmount();
	
	Collection<CartItem> getItems();
}
