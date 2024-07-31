package com.poly.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.bean.Users;
import com.poly.service_bean.InventoryService;
import com.poly.service_bean.ProductService;
import com.poly.service_bean.UsersService;

@Controller
public class HomeController {
	@Autowired
	UsersService usersService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	InventoryService invenService;

	@Autowired
	HttpSession session;
	
	@RequestMapping({"/","/home/index"})
	public String GetHome(Model m) {
		m.addAttribute("items", productService.findAll());
		return "home/index";
	}
	
	@RequestMapping("/home/details/{id}")
	public String GetDetails(Model m, @PathVariable("id") Integer id) {
		m.addAttribute("item", productService.findById(id));
		m.addAttribute("inven", invenService.findByID(id));
		return "home/detailsWatch";
	}
	
	@RequestMapping("/home/cart")
	public String GetCart(Model m, HttpSession ss) {
		Users u = (Users) ss.getAttribute("users");
		m.addAttribute("u", usersService.findById(u.getUsername()));
		return "home/cart";
	}
	
	@RequestMapping("/user/profile")
	public String GetProfile(Model m) {
		Users u =  (Users) session.getAttribute("users");
		m.addAttribute("profile", usersService.findById(u.getUsername()));
		return "home/profile";
	}
	
	@RequestMapping("/user/order")
	public String GetOrder(Model m) {
		
		return "home/order";
	}
	
	
}
