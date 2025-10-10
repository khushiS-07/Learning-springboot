package com.khushi.project_alpha_one.service;

import java.util.ArrayList;
import java.util.List;

import com.khushi.project_alpha_one.dto.ProductDTO;
import com.khushi.project_alpha_one.dto.ProductResponse;
import com.khushi.project_alpha_one.model.Product;

public interface ProductService {
	
	// get product
	
	public ProductResponse getProducts();
	
	// add product
	
	public ProductDTO addProducts( ProductDTO productDTO);
	
	// delete product 
	
	public ProductDTO removeproducts( Long productId);
	
	// update product
	
	public ProductDTO updateproducts( Long productId, ProductDTO productDTO);
	
	// get one product details
	
	public ProductDTO getOneProduct( Long productId);
		
}
