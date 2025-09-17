package com.khushi.project_alpha_one.service;

import java.util.ArrayList;
import java.util.List;


import com.khushi.project_alpha_one.model.Product;

public interface ProductService {
	
	// get product
	
	public List<Product> getProducts();
	
	// add product
	
	public String addProducts( Product product);
	
	// delete product 
	
	public String removeproducts( int productId);
	
	// update product
	
	public String updateproducts( int productId, Product product);
	
	
	
	
	
	
}
