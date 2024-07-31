package com.poly.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.poly.bean.Users;

public interface UsersDAO extends JpaRepository<Users, String>{
	@Query("SELECT o FROM Users o WHERE o.email =?1")
	Users findByUsersEmailObject(String id);
	
	
	@Query(value = "select u.username, u.fullname, u.passwords, u.email, u.phone , u.active, u.blocked, u.failed_login_attempts, u.last_login, u.roles "
			+ "from users u inner join  Logs l  on l.username = u.username "
			+ "group by u.username, u.fullname, u.passwords, u.email, u.phone , u.active, u.blocked, u.failed_login_attempts, u.last_login, u.roles" , nativeQuery = true)
	List<Users> findByKeywordsBySQL();
	
	@Query("SELECT DISTINCT ar.username FROM UserRole ar WHERE ar.roleid.roles_id IN ('USER')")
	List<Users> getAdministrators();
	 Users findByUsername(String username);
}
