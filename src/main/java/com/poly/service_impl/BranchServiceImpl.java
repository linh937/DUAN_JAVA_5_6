package com.poly.service_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.bean.Branch;
import com.poly.dao.BranchDAO;
import com.poly.service_bean.BranchService;

@Service
public class BranchServiceImpl implements BranchService{

	@Autowired
	BranchDAO dao;

	@Override
	public List<Branch> findAll() {
		
		return dao.findAll();
	}
}
