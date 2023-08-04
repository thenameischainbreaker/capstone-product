package com.capstone.capstoneproduct.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.capstoneproduct.entity.Category;
import com.capstone.capstoneproduct.entity.Product;
import com.capstone.capstoneproduct.entity.ProductCategory;
import com.capstone.capstoneproduct.repository.CategoryRepository;
import com.capstone.capstoneproduct.repository.ProductCategoryRepository;
import com.capstone.capstoneproduct.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
@Autowired
ProductRepository productRepo;
@Autowired
CategoryRepository categoryRepo;
@Autowired
ProductCategoryRepository productCategoryRepo;
	
	@Override
	//check if admin and logged in
	public boolean postProduct(Product product) throws SQLException {
		// TODO Auto-generated method stub
		product.setP_id(0);
		
		productRepo.save(product);
		return true;
		
	}

	@Override
	//check if admin and logged in
	public boolean updateProduct(Product product) throws SQLException {
		// TODO Auto-generated method stub
		if(! productRepo.existsById(product.getP_id()))
		 return false;
		else {
		Product	oldProduct = productRepo.findById(product.getP_id()).get();
		oldProduct.setP_name(product.getP_name());
		oldProduct.setImage_id(product.getImage_id());
		oldProduct.setP_description(product.getP_description());
		oldProduct.setP_name(product.getP_name());
		oldProduct.setP_price(product.getP_price());
		productRepo.save(oldProduct);
		return true;
		}
	}

	@Override
	public Product getProduct(int id) throws SQLException {
		// TODO Auto-generated method stub
		return productRepo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public List<Product> getProductByCategories(Integer... Id) {
		// TODO Auto-generated method stub
		int length = Id.length;
		if(length == 0) {
			return getAllProducts();
		}
		List<Integer> id_list =  new ArrayList<>(Arrays.asList(Id));
		System.out.println("id list: " + id_list);
		List<Integer> product_id_list = productRepo.getProductIdsByCategories(id_list, length);
		System.out.println("here");
		List<Product> product_list = new ArrayList<Product>();
		System.out.println("product_id_list :" + product_id_list);
	
		product_list = productRepo.findAllById(product_id_list);
		System.out.println("product list: " + product_list);
	
	
		System.out.println(product_list);
		return product_list;
		
	}

	@Override
	//if admin and logged in
	public boolean createCategory(Category newCategory) {
		// TODO Auto-generated method stub
		newCategory.setC_id(0);
		categoryRepo.save(newCategory);
		
		return true;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	@Override
	public boolean addProductCategory(ProductCategory newProductCategory) {
		// TODO Auto-generated method stub
		newProductCategory.setC_id(0);
		if (productCategoryRepo.getCategoriesByMatch(newProductCategory.getP_id(), newProductCategory.getC_id()) == 0 ) {
		productCategoryRepo.save(newProductCategory);
		return true;
		}
		else
			return false;
			
		
	}

	@Override
	public boolean deleteProductCategory(ProductCategory newProductCategory) {
		// TODO Auto-generated method stub
		if (productCategoryRepo.getCategoriesByMatch(newProductCategory.getP_id(), newProductCategory.getC_id()) == 0 )
			return false;
		else 
			return true;
		
		
	
	}

	@Override
	public Integer getTotalPriceByIds(List<Integer> productIds) {
		// TODO Auto-generated method stub
		return productRepo.getTotalPriceByIds(productIds);
	}

	@Override
	public List<Product> getAllByIds(List<Integer> productIds) {
		// TODO Auto-generated method stub
		return productRepo.findAllById(productIds);
	}

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		 return categoryRepo.findAll();
	}

	
	
	
	
}
