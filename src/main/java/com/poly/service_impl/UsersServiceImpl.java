package com.poly.service_impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//<<<<<<< HEAD
//import org.apache.tomcat.util.net.jsse.PEMFile;
//import org.springframework.security.core.Authentication;
//=======
//>>>>>>> branch 'main' of https://github.com/tungit04315/ASMJava6.git
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;
import com.poly.bean.UserRole;
import com.poly.bean.Users;
import com.poly.dao.UserRoleDAO;
import com.poly.dao.UsersDAO;
import com.poly.service_bean.UsersService;

@Service
public class UsersServiceImpl implements UsersService{

	@Autowired
	BCryptPasswordEncoder pe;
	
	@Autowired
	UsersDAO dao;
	@Autowired
	UserRoleDAO userRoleDao;
	
	
	@Override
	public List<Users> findAll() {
		
		return dao.findAll();
	}

	@Override
	public Users findById(String id) {
		Users users = dao.findById(id).orElse(null);
		if(users!=null) {
			return users;
		}else {
			return null;
		}
	}

	@Override
	public Users create(Users u) {
		return dao.save(u);
		
	}

	@Override
	public Users update(Users u) {
		return dao.save(u);
	}

	@Override
	public void delete(String id) {
		dao.deleteById(id);
	}

	@Override
	public Users findByObject(String email) {
		return dao.findByUsersEmailObject(email);
	}

	@Override
	public List<String> getRolesByUsername(String username) {
		List<String> roleNames = new ArrayList<>();

		List<UserRole> authorities = userRoleDao.findAll();

		for (UserRole userRole : authorities) {
			if(userRole.getUsername().getUsername().equals(username)){
				roleNames.add(userRole.getRoleid().getRoles_id());
			}
		}
		return roleNames;
	}

	@Override
	public Optional<Users> getAccount(String username) {
		return dao.findById(username);
	}

	@Override
	public Users findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
}
