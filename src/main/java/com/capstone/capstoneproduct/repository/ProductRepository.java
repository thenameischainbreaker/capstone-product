package com.capstone.capstoneproduct.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capstone.capstoneproduct.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	 @Query(value = "SELECT p_id FROM product_category WHERE c_id IN (:categoryIds) GROUP BY p_id HAVING COUNT(DISTINCT c_id) = :categoryIdCount", nativeQuery = true)
	    List<Integer> getProductIdsByCategories(List<Integer> categoryIds, int categoryIdCount);
	
	@Query( value="SELECT SUM(p_price) FROM product WHERE p_id IN (:productIds)", nativeQuery = true)
	 	Integer getTotalPriceByIds(@Param("productIds") List<Integer> productIds);
	
	
		
}
