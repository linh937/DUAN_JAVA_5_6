package com.poly.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "roles")
public class Roles implements Serializable{
	
	@Id
	String roles_id;
	String roles_name;
	
//	@JsonIgnore
//	@OneToMany(mappedBy = "role")
//	List<Users> user;
	
	@JsonIgnore
	@OneToMany(mappedBy = "roleid")
	List<UserRole> UserRole;
}
