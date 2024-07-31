package com.poly.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.bean.Users;
import com.poly.service.CookieService;
import com.poly.service_bean.OrderDetailService;
import com.poly.service_bean.OrderService;



@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderDetailService orderDetailSer;
	@Autowired
	CookieService cookieService;
	

	
	@RequestMapping("/order/checkout")
	public String CheckOut() {
		return "order/checkout";
	}

//	@RequestMapping("/order/list")
//	public String getList(Model model, HttpServletRequest request) {
//	    // Lấy thông tin email từ Cookie
//	    String email = cookieService.getValue(request, "auth");
//	    System.out.println(orderService.findByUsername(email));
//	    if (email != null) {
//	        // Giả sử orderService có phương thức findByEmail để tìm đơn hàng theo email
//	        
//	        model.addAttribute("order", orderService.findByUsername(email));
//	        
//	        return "home/order";
//	    } else {
//	        // Nếu không tìm thấy thông tin email trong Cookie, chuyển hướng đến trang đăng nhập
//	        return "redirect:/account/login/form";
//	    }
//	}
	@RequestMapping("/order/list")
	public String getList(Model m, HttpSession ss) {
		Users u = (Users) ss.getAttribute("users");
//		System.out.println(u.getEmail());
		m.addAttribute("order", orderService.findByUsername(u.getEmail()));
		return "home/order";
	}


	@RequestMapping("/order/detail/{id}")
	public String getView(Model m, @PathVariable("id") Integer id) {
		m.addAttribute("order", orderService.findByID(id));
		m.addAttribute("detailOrder", orderDetailSer.findAllOrderDetail(id));
		return "home/homeDetail";
	}

}
