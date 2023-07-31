package com.capstone.capstoneproduct;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

@Service
public interface ProductDAO {
	public boolean postProduct(Product product) throws SQLException;
	public boolean updateProduct(Product product, int id) throws SQLException;
	public Product getProduct(int id) throws SQLException;
}
