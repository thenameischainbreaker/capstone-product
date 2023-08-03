package com.capstone.capstoneproduct.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_category")
public class ProductCategory {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private int p_id;
private int c_id;

public ProductCategory() {
	
}



public ProductCategory(int id, int p_id, int c_id) {
	super();
	this.id = id;
	this.p_id = p_id;
	this.c_id = c_id;
}



public int getP_id() {
	return p_id;
}

public void setP_id(int p_id) {
	this.p_id = p_id;
}

public int getC_id() {
	return c_id;
}

public void setC_id(int c_id) {
	this.c_id = c_id;
}



public int getId() {
	return id;
}



public void setId(int id) {
	this.id = id;
}


	
	
}
