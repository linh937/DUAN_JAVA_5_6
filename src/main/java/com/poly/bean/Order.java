package com.poly.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
//@Table(name = "orders", 
//uniqueConstraints = {
//		@UniqueConstraint(columnNames = {
//				"voucher","status"
//		})
//})
public class Order implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orders_id;
	private String fullname;
	private String email;
	private String phone;
	private String orders_address;
	
	@ManyToOne
	@JoinColumn(name = "voucher")
	Voucher voucher;
	
	@ManyToOne
	@JoinColumn(name = "status")
	Status status;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "orders_time")
	Date orders_time = new Date();
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "order")
	List<OrderDetail> orderDetail;
	
}
