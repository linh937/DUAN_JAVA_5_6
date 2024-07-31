package com.poly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.poly.service.ParamService;
import com.poly.service.SessionService;
import com.poly.service_bean.LogsService;
import com.poly.service_bean.UsersService;

@Controller
public class UserListController {

	@Autowired
	ParamService param;
	
	@Autowired
	SessionService ssSer;
	
	@Autowired
	LogsService dao;
	
	@Autowired
	UsersService udao;
	
	@GetMapping("/admin/userlist")
	public String getUserList(Model m) {
		m.addAttribute("lists", udao.findAll());
		
		return "/admin/userList";
	}
	
	@GetMapping("/admin/historylogs")
	public String getHistoryLogs(Model m) {
		
		m.addAttribute("logs", dao.findAll());
		
		return "/account/loginHistory";
	}
	
	@GetMapping("/admin/delelelogs/{id}")
	public String getDeleteLogs(Model m, @PathVariable("id") Integer id) {
		dao.delete(id);
		return "redirect:/admin/historylogs";
	}
	
}
