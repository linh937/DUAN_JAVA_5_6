package com.poly.service_bean;

import java.util.List;

import com.poly.bean.Inventory;

public interface InventoryService {

	public List<Inventory> findAll();
	
	public Inventory findByID(Integer id);
	
	public Inventory create(Inventory product);

	public Inventory update(Inventory product);

	public void delete(Integer id);
}
