package com.poly.service_impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poly.bean.Order;
import com.poly.bean.OrderDetail;
import com.poly.dao.OrderDAO;
import com.poly.dao.OrderDetailDAO;
import com.poly.service_bean.OrderDetailService;
import com.poly.service_bean.OrderService;


@Service
public class OrderDetailServiceImpl implements OrderDetailService {
	

	@Autowired
	OrderDetailDAO ddao;

	@Override
	public List<OrderDetail> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetail findByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDetail> findAllOrderDetail(Integer OrderID) {
		return ddao.findByAllDetailOrder(OrderID);
	}

	

}
