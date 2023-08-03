package com.capstone.capstoneproduct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capstone.capstoneproduct.entity.ProductCategory;
@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer>
{
@Query(value = "SELECT COUNT(*) from product_category pc WHERE pc.p_id = :p_id AND pc.c_id = :c_id ", nativeQuery = true)
public int getCategoriesByMatch(@Param("p_id") int p_id, @Param("c_id") int c_id);
	


	
}
