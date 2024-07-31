package com.poly.service_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.bean.ThongKe;
import com.poly.dao.ThongKeDAO;
import com.poly.service_bean.ThongKeService;

@Service
public class ThongKeServiceImpl implements ThongKeService{

	@Autowired
	ThongKeDAO dao;
	
	@Override
	public List<ThongKe> getListTK() {
		List<ThongKe> list = dao.getListTK();
		return list;
	}

	@Override
	public Long getLuotMua() {
		Long lm = dao.getLuotMua();
		return lm;
	}

}
