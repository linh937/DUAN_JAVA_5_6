package com.poly.service_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.bean.ThongKe;
import com.poly.dao.ThongKeDAO;
import com.poly.service_bean.StaticsService;

@Service
public class StaticsServiceImpl implements StaticsService{

	@Autowired
	ThongKeDAO dao;
	
	@Override
	public List<ThongKe> findAll() {
		return dao.findAll();
	}

}
