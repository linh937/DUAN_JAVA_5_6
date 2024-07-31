package com.poly.service_bean;

import java.util.List;

import com.poly.bean.Logs;

public interface LogsService {
	public List<Logs> findAll();
	
	public void delete(Integer id);
}
