package com.poly.service_bean;

import java.util.List;

import com.poly.bean.OrderDetail;

public interface OrderDetailService {

	public List<OrderDetail> findAll();
	
	public OrderDetail findByID(Long id);
	
	public List<OrderDetail> findAllOrderDetail(Integer OrderID);
	
}
