package com.poly.service_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.poly.bean.ProductType;
import com.poly.dao.ProductTypeDAO;
import com.poly.service_bean.ProductTypeService;

@Service
public class ProductTypeServiceImpl implements ProductTypeService{

	@Autowired
	ProductTypeDAO dao;

	@Override
	public List<ProductType> findAll() {
		return dao.findAll();
	}
}
