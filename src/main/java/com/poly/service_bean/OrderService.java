package com.poly.service_bean;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.poly.bean.Order;

public interface OrderService {

	public List<Order> findAllOrder();
	
	public Order findByID(Integer id);
	
	public Order create(JsonNode orderData);

	public List<Order> findByUsername(String username);
	// Giả sử bạn đang trả về một danh sách các đơn hàng từ phương thức này
	
}
