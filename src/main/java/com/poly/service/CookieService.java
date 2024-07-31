package com.poly.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CookieService {
	@Autowired
	HttpServletRequest req;
	
	@Autowired
	HttpServletResponse res;
	
	public Cookie create(String name, String value, int days) {
		Cookie cookie = new Cookie(name, value);
		
		cookie.setMaxAge(days * 60 * 60 * 24);
		cookie.setPath("/");
		
		res.addCookie(cookie);
		
		return cookie;
	}
	
	public Cookie get(String name) {
		Cookie[] cookies = req.getCookies();
		
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equalsIgnoreCase(name)) {
					return c;
				}
			}
		}
		
		return null;
	}
	
	public String getValue(HttpServletRequest request, String name) {
		
		Cookie[] cookies = req.getCookies();
		if(cookies != null){
			for(Cookie c : cookies) {
				if(c.getName().equalsIgnoreCase(name)) {
					return c.getValue();
				}
			}
		}
		
		return null;
	}
	
	public void delete(String name) {
		Cookie c = new Cookie(name, "");
		c.setMaxAge(0);
		c.setPath("/");
		res.addCookie(c);
	}
}
