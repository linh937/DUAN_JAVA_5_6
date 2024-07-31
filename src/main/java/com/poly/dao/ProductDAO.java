package com.poly.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.poly.bean.Products;

public interface ProductDAO extends JpaRepository<Products, Integer>{

	@Query(value = "select * from product p where p.product_price = (select MIN(p.product_price) from product p)" , nativeQuery = true)
	Products findByKeywordsBySQL();
	
	@Query(value = "select top 1 * from product p order by p.product_id desc" , nativeQuery = true)
	Products findTop1ProductIdBySQL();
	
	@Query(value = "select * from product p where p.product_id not in (select i.product_id from inventory i where i.quantity = 0) and p.product_price not in (select min(p.product_price) from product p)" , nativeQuery = true)
	List<Products> findByKeywordsAllBySQL();
	
	@Query(value = "select * from product p where p.product_name like %?1%" , nativeQuery = true)
	List<Products> findByKeywordsAllBySQL(String name);
	
	@Query(value = "select c.product_id, p.product_img, p.product_name, p.product_price, p.types_id ,p.brands_id, p.product_describe, c.quantity "
			+ " from product p inner join cart c on c.product_id = p.product_id "
			+ " where c.username = ?1 "
			+ " group by c.product_id, p.product_img, p.product_name, p.product_price, p.types_id, p.brands_id, p.product_describe, c.quantity " , nativeQuery = true)
	List<Products> findCartByKeyWordBySQL(int maKH);
	
	@Query("SELECT p FROM Products p WHERE p.branch.brands_id=?1")
	List<Products> findByBranchId(Integer cid);
	
	@Query("SELECT p FROM Products p WHERE p.type.types_id=?1")
	List<Products> findByTypeId(Integer cid);
}
