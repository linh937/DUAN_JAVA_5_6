package com.poly.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.bean.Inventory;

public interface InventoryDAO extends JpaRepository<Inventory, Integer>{

	@Query("select i from Inventory i")
	List<Inventory> getListInventories();
	
	Inventory  findBfindById(int id);
	
	@Query(value="select * from inventory i where i.product_id = ?1", nativeQuery=true)
	Inventory findObject(Integer id);
	
}
