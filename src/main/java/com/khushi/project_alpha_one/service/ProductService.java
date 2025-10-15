package com.khushi.project_alpha_one.service;

import java.util.ArrayList;
import java.util.List;

import com.khushi.project_alpha_one.dto.ProductDTO;
import com.khushi.project_alpha_one.dto.ProductResponse;

public interface ProductService {
	
	// get product
	
	public ProductResponse getProducts(int pageNumber, int size);
	
	// add product
	
	public ProductDTO addProducts( ProductDTO productDTO);
	
	// delete product 
	
	public ProductDTO removeproducts( Long productId);
	
	// update product
	
	public ProductDTO updateproducts( Long productId, ProductDTO productDTO);
	
	// get one product details by id
	
	public ProductDTO getOneProduct( Long productId);
	
	// product name update by id using patch
	
	public ProductDTO updateProductByName(Long productId , String newName);
	
	//get product by alpha "A"
	
	public ProductResponse getProductByAlpha(String alpha, int pageNumber, int size);
	
	
		
}
