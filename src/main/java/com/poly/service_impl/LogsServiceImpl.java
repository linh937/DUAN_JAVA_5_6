package com.poly.service_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.bean.Logs;
import com.poly.dao.LogsDAO;
import com.poly.service_bean.LogsService;

@Service
public class LogsServiceImpl implements LogsService{

	@Autowired
	LogsDAO dao;
	
	@Override
	public List<Logs> findAll() {
		return dao.findAll();
	}

	@Override
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}

}
