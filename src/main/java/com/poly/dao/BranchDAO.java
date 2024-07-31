package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.bean.Branch;

public interface BranchDAO extends JpaRepository<Branch, Integer>{

}
