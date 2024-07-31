
package com.poly.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.bean.UserRole;
import com.poly.bean.Users;


public interface UserRoleDAO extends JpaRepository<UserRole, Integer>{
	@Query("SELECT DISTINCT a FROM UserRole a WHERE a.username IN ?1")
	List<UserRole> authoritiesOf(List<Users> accounts);
}
