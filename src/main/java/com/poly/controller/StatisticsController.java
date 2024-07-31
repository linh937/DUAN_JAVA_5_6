package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poly.bean.ThongKe;
import com.poly.service_bean.ThongKeService;

@Controller
public class StatisticsController {
	
	@Autowired
	ThongKeService tkDao;
	double tongTien = 0, doanhThu=0;
	
	@RequestMapping("/admin/thongke")
//	@ResponseBody
	public String showTK(Model m) {
		List<ThongKe> listTK = tkDao.getListTK();
		for (ThongKe tk : listTK) {
			tongTien= tk.getPrice()*tk.getTotal_qty();
			doanhThu+=tongTien;
		}
		m.addAttribute("listTK", listTK);
		m.addAttribute("doanhThu", doanhThu);
		m.addAttribute("luotMua", tkDao.getLuotMua());
		
		return "/admin/statistic";
	}
}
