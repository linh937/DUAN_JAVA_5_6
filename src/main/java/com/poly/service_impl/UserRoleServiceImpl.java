package com.poly.service_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.bean.UserRole;
import com.poly.dao.UserRoleDAO;
import com.poly.service_bean.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService{
	@Autowired
	UserRoleDAO dao;
	
	@Override
	public UserRole create(UserRole userRole) {
		return dao.save(userRole);
	}

}
