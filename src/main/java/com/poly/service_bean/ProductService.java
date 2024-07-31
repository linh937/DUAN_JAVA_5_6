package com.poly.service_bean;

import java.util.List;

import com.poly.bean.Products;


public interface ProductService {

	public List<Products> findAll();

	public Products findById(Integer id);

	public List<Products> findByBranchId(Integer cid);
	
	public List<Products> findByTypeId(Integer cid);

	public Products create(Products product);

	public Products update(Products product);
	
	public Products findTop1ProductIdBySQL();

	public void delete(Integer id);
}
