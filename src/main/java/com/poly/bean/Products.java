package com.poly.bean;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "product")
public class Products implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int product_id;
	private String product_name;
	private String product_img;
	private String product_describe;
	private double product_price;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "brands_id")
	Branch branch;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "types_id")
	ProductType type;
	
	private int views;
	
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	List<OrderDetail> orderDetail;
	
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	List<CartItem> cart;
	
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	List<Inventory> inven;
}
