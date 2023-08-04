package com.capstone.capstoneproduct.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.capstone.capstoneproduct.entity.Category;
import com.capstone.capstoneproduct.entity.Product;
import com.capstone.capstoneproduct.entity.ProductCategory;


public interface ProductService {
	public boolean postProduct(Product product) throws SQLException;
	public boolean updateProduct(Product product) throws SQLException;
	public Product getProduct(int id) throws SQLException;
	public List<Product> getProductByCategories(Integer... Id);
	
	
	public boolean createCategory(Category newCategory);
	public List<Product> getAllProducts();
	
	public boolean addProductCategory(ProductCategory newProductCategory);
	public boolean deleteProductCategory(ProductCategory newProductCategory);
	public Integer getTotalPriceByIds(List<Integer> productIds);
	public List<Product> getAllByIds(List<Integer> productIds);
	public List<Category> getAllCategories();
	
}
