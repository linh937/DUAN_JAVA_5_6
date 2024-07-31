package com.poly.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.bean.CartItem;

public interface CartItemDAO extends JpaRepository<CartItem, Integer> {
	@Query(value="select * "
			+ "from cart c where c.product_id =:id and c.username =:uid", nativeQuery=true)
	List<CartItem> findAllBySQL(@Param("id") Integer id, @Param("uid") Integer uid);
	
	@Query(value="select * "
			+ "from cart c where c.username =:uid", nativeQuery=true)
	List<CartItem> findAllBySQL(@Param("uid") Integer uid);
	
	@Query(value="select * "
			+ "from cart c where c.product_id =:id and c.username =:uid", nativeQuery=true)
	CartItem findByObjectCartSQL(@Param("id") Integer id, @Param("uid") Integer uid);
	
	@Query(value = "select c.cart_id ,c.product_id, p.product_img, p.product_name, p.product_price, p.types_id ,p.brands_id, p.product_describe, c.quantity "
			+ " from cart c inner join product p on c.product_id = p.product_id "
			+ " where c.username =:id "
			+ " group by c.cart_id ,c.product_id, p.product_img, p.product_name, p.product_price, p.types_id, p.brands_id, p.product_describe, c.quantity " , nativeQuery = true)
	List<CartItem> findCartByKeyWordBySQL(@Param("id") Integer maKH);
	
//	
//	@Query(value="select COUNT(c.product_id) as SL "
//			+ "from cart c where c.product_id =:prid and c.username =uid", nativeQuery=true)
//	Integer findQuantityProductCart(@Param("prid") Integer id, @Param("uid") Integer uid);
}
