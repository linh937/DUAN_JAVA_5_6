package com.poly.service_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.bean.Roles;
import com.poly.dao.RoleDAO;
import com.poly.service_bean.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	RoleDAO dao;
	
	@Override
	public Roles findbyId(String id) {
		return dao.findById(id).get();
	}

}
