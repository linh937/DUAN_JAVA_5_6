package com.poly.rest;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.poly.bean.*;
import com.poly.map.*;


@Repository
public class RestfulAPI {
	RestTemplate rest = new RestTemplate();

	String url = "";

	private String getURL(String key) {
		return url.replace(".json", "/" + key + ".json");
	}

	public UsersMAP findAll() {
		return rest.getForObject(url, UsersMAP.class);
	}
	
	public Users findByKey(String key) {
		return rest.getForObject(getURL(key), Users.class);
	}
	
	public String add(Users data) {
		HttpEntity<Users> entity = new HttpEntity<>(data);
		JsonNode resp = rest.postForObject(url, entity, JsonNode.class);
		return resp.get("name").asText();
	}
	
	public Users update(String key, Users data) {
		HttpEntity<Users> entity = new HttpEntity<>(data);
		rest.put(getURL(key), entity);
		return data;
	}
	
	public void delete(String key) {
		rest.delete(getURL(key));
	}
	
}
