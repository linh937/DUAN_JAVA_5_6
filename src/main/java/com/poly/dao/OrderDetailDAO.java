package com.poly.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.bean.OrderDetail;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long>{

	
	@Query("SELECT o FROM OrderDetail o WHERE o.order.orders_id =?1")
	List<OrderDetail> findByAllDetailOrder(Integer id);
}
