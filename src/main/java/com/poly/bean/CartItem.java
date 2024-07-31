package com.poly.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "cart")
public class CartItem implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cart_id;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "username")
	Users users;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "product_id")
	Products product;
	
	private int quantity = 1;

	public CartItem(CartItem item) {
//		this.cart_id = item.getCart_id();
//		this.users = item.getUsers();
//		this.product = item.getProduct();
//		this.quantity = 1;
	}
}
