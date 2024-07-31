package com.poly.service_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.bean.Products;
import com.poly.dao.ProductDAO;
import com.poly.service_bean.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDAO dao;
	
	@Override
	public List<Products> findAll() {
		return dao.findAll();
	}

	@Override
	public Products findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public List<Products> findByBranchId(Integer cid) {
		return dao.findByBranchId(cid);
	}

	@Override
	public List<Products> findByTypeId(Integer cid) {
		return dao.findByTypeId(cid);
	}

	@Override
	public Products create(Products product) {
		return dao.save(product);
	}

	@Override
	public Products update(Products product) {
		return dao.save(product);
	}

	@Override
	public void delete(Integer id) {
		dao.deleteById(id);
	}
	
	@Override
	public Products findTop1ProductIdBySQL() {
		
		return dao.findTop1ProductIdBySQL();
	}

}
