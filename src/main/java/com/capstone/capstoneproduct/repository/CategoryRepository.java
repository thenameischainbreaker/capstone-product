package com.capstone.capstoneproduct.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.capstoneproduct.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {


	
	
	
}