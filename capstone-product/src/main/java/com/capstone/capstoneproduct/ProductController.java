package com.capstone.capstoneproduct;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductDAO repo;
	
	@PostMapping("/add")
	public String postProduct(@RequestBody Product product) throws SQLException
	{
		if(repo.postProduct(product))
			return "Product Posted";
		else
			return "Product Not Posted";
	}
	
	@PutMapping("/update/{id}")
	public String updateProduct(@RequestBody Product product, @PathVariable int id) throws SQLException
	{
		if(repo.updateProduct(product, id))
			return "Product Updated";
		else
			return "Product Not Updated";
	}
	
	@GetMapping("/get/{id}")
	public Product getProduct(@PathVariable int id) throws SQLException
	{
		return repo.getProduct(id);
	}
}
