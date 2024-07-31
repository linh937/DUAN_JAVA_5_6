package com.poly.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SessionService {
	@Autowired
	HttpSession ss;
	
	public void setAttribute(String name, Object value) {
		ss.setAttribute(name, value);
	}
	
	public <T> T getAttribute(String name) {
		return (T) ss.getAttribute(name);
	}
	
	public void removeAttribute(String name) {
		ss.removeAttribute(name);
	}
}
