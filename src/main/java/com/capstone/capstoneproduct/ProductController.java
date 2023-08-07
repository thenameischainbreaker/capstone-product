package com.capstone.capstoneproduct;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capstone.capstoneproduct.dto.UserRole;
import com.capstone.capstoneproduct.entity.Admin;
import com.capstone.capstoneproduct.entity.Category;
import com.capstone.capstoneproduct.entity.Product;
//import com.capstone.capstoneproduct.service.ProductDAO;
import com.capstone.capstoneproduct.service.ProductServiceImpl;



@RestController
@RequestMapping("/product")



@CrossOrigin(origins = {"https://domainofchain.s3.us-east-2.amazonaws.com", "http://localhost:4200/", "http://localhost:4200/","https://capstone-angular-jj.s3.us-east-2.amazonaws.com"})

public class ProductController {
	@Autowired
	ProductServiceImpl service;
	@Value("${gateway-host}")
	private String gatewayHost;	
	//ProductDAO repo;
	
	@PostMapping(path="/add", produces=MediaType.APPLICATION_JSON_VALUE)
	//check if admin and logged in
	public String postProduct(@RequestHeader("googleBearerToken") String headerValue, @RequestBody Product product) 
	{
		try {
			 RestTemplate restTemplate = new RestTemplate(); 
			  String url = "http://" + gatewayHost + "/user/getUserRole";
		//	  System.out.println("gatewayHost: " +gatewayHost);
			  UserRole response = restTemplate.postForObject(url, headerValue, UserRole.class); 
			if(response.getRole() == Admin.FALSE || !response.isTokenValid()) {
				System.out.println("response.getRole: " + response.getRole());
				System.out.println("!response.isTokenValid: " + !response.isTokenValid());
				throw new SecurityException();
			}
			
			
			if(service.postProduct(product))
				return "\"Product Posted\"";
			else
				return "\"Product Not Posted\"";
		}
		catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "\"Error in adding product. Check permissions.\"";
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "\"Error in adding product.\"";
		}
	}
	
	@PutMapping("/update")
	//check if admin and logged in
	public String updateProduct(@RequestHeader("googleBearerToken") String headerValue, @RequestBody Product product) 
	{
		try {
			 RestTemplate restTemplate = new RestTemplate(); 
			  String url = "http://" + gatewayHost + "/user/getUserRole";
		//	  System.out.println("gatewayHost: " +gatewayHost);
			  UserRole response = restTemplate.postForObject(url, headerValue, UserRole.class); 
			if(response.getRole() == Admin.FALSE || !response.isTokenValid())
				throw new SecurityException();
			
			
			
			
			if(service.updateProduct(product))
				return "\"Product Updated\"";
			else
				return "\"Product Not Updated\"";
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "\"Error in updating product. Check permissions.\"";
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "\"Error in updating product\"";
		}
	}
	
	@GetMapping("/getById/{id}")
	public Product getProductById(@PathVariable int id) throws SQLException
	{
		return service.getProduct(id);
	}
	
	
	@GetMapping("getAll")
	public List<Product> getAllProducts(){
		return service.getAllProducts();
	}
	//check if admin and logged in
	@PostMapping("/newCategory")
	public String newCategory(@RequestHeader("googleBearerToken") String headerValue, @RequestBody Category newCategory) {
	try {
		RestTemplate restTemplate = new RestTemplate(); 
		  String url = "http://" + gatewayHost + "/user/getUserRole";
	//	  System.out.println("gatewayHost: " +gatewayHost);
		  UserRole response = restTemplate.postForObject(url, headerValue, UserRole.class); 
		if(response.getRole() == Admin.FALSE || !response.isTokenValid())
			throw new SecurityException();
		
		
		return	service.createCategory(newCategory) == true ? "New category added" : "Category not added";
	} catch (SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return "\"Error in adding category. Check permissions.\"";
	}
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return "\"Error in adding category.\"";
	}
	}
	
	@GetMapping("/getProductsByCategories")
	public List<Product> getProductsByCategories(@RequestParam("ids") Integer[] ids) {
		
		return service.getProductByCategories(ids);
		
	}
	
	@PostMapping("/getTotalPriceByIds")
	public Integer getTotalPriceByIds(@RequestBody List<Integer> productIds){
		return service.getTotalPriceByIds(productIds);
	}
	
	@PostMapping("/getAllByIds")
	public List<Product> getAllByIds(@RequestBody List<Integer> productIds){
		return service.getAllByIds(productIds);
	}
	
	@GetMapping("/getAllCategories")
	public List<Category> getAllCategories(){
		return service.getAllCategories();
	}
	
	}
	
	

