package com.poly.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@Table(name = "detail_orders", 
//uniqueConstraints = {
//		@UniqueConstraint(columnNames = {
//				"product_id","orders_id"
//		})
//})
@Table(name = "detail_orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long detailorder_id;
	Integer quantity;
	Long price;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	Products product;
	
	@ManyToOne
	@JoinColumn(name = "orders_id")
	Order order;
}
