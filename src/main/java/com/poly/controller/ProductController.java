package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.bean.Branch;
import com.poly.bean.Inventory;
import com.poly.bean.ProductType;
import com.poly.bean.Products;
import com.poly.service.ParamService;
import com.poly.service.SessionService;
import com.poly.service_bean.BranchService;
import com.poly.service_bean.InventoryService;
import com.poly.service_bean.ProductService;
import com.poly.service_bean.ProductTypeService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService dao;
	
	@Autowired
	BranchService branchDAO;
	
	@Autowired
	ProductTypeService typeDAO;
	
	@Autowired
	ParamService param;
	
	@Autowired
	SessionService ss;
	
	@Autowired
	InventoryService inventoryDao;
	
	// Đầu Thêm sản phẩm
	@GetMapping("/product/addproduct")
	public String GetAddProduct(Model model) {
		
		List<Branch> branchs = branchDAO.findAll();
		List<ProductType> types = typeDAO.findAll();
		
		System.out.println("Branchs: " + branchs);
	    System.out.println("Types: " + types);
	    
		model.addAttribute("branchs", branchs);
		model.addAttribute("types", types);
		
		
		return "/manager/addProduct";
	}
	
	
	@PostMapping("/product/addproduct")
	public String SetAddProduct(Model m, Products p) {
		try {
//			String img = file.getOriginalFilename();
			String img = param.getString("product_img", "");
			double price = Double.parseDouble(param.getString("product_price", ""));
			
			p.setProduct_img(img);
			p.setProduct_price(price);
			
			dao.create(p);
			
			Products newProduct = dao.findTop1ProductIdBySQL();
			Inventory inven = new Inventory();
			
			inven.setProduct(newProduct);
			inven.setQuantity(0);
			inventoryDao.create(inven);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/product/addproduct";
		
	}
	// Cuối Thêm sản phẩm
	

	// Đầu Cập nhật sản phẩm
	@GetMapping("/product/UpdateProduct")
	public String getUpdateProduct(Model m) {
		
		List<Products> p = dao.findAll();
		
		List<Branch> branchs = branchDAO.findAll();
		List<ProductType> types = typeDAO.findAll();
		
		m.addAttribute("typesList", types);
		m.addAttribute("branchsList", branchs);
		
		m.addAttribute("products", p);
		return "/manager/updateProduct";
		///
	}
	
	@RequestMapping("/product/edit/{id}")
	public String edit(Model m, @PathVariable("id") Integer id) {
		Products item = dao.findById(id);
		m.addAttribute("item", item);
		List<Products> items = dao.findAll();
		
		List<Branch> branchs = branchDAO.findAll();
		List<ProductType> types = typeDAO.findAll();
		
		m.addAttribute("typesList", types);
		m.addAttribute("branchsList", branchs);
		
		ss.setAttribute("id", item.getProduct_id());
		
		m.addAttribute("products", items);
		return "/manager/updateProduct";
	}
	
	@PostMapping("/product/updateProduct")
	public String update(Products item)  {
		
		int id = ss.getAttribute("id");
		
		Products find = dao.findById(id);
		String img = param.getString("product_img", "");
		
		item.setProduct_id(find.getProduct_id());
		item.setProduct_img(img);
		item.setBranch(find.getBranch());
		item.setType(find.getType());
		
		dao.create(item);
		return "redirect:/product/edit/" + item.getProduct_id();
	}
	
	@RequestMapping("/product/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		dao.delete(id);
		return "redirect:/product/UpdateProduct";
	}
	
	// Đầu Cập nhật sản phẩm
	
	@GetMapping("/product/listproduct") 
	public String getListProduct(Model m) {
		
		List<Products> items = dao.findAll();
		m.addAttribute("items", items);
		return "/manager/listProduct";
	}
}
