package com.khushi.project_alpha_one.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.khushi.project_alpha_one.model.Product;


@Service
public class ProductServiceImplementation implements ProductService {
	
	List<Product> products = new ArrayList<>();

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return products;
	}

	@Override
	public String addProducts(Product product) {
		// TODO Auto-generated method stub
		products.add(product);
		return "Product is with id : " + product.getProductId() + " Added sucessfully!";
	}

	@Override
	public String removeproducts(int productId) {
		// TODO Auto-generated method stub
		productId = productId-1;
		products.remove(productId);
		return "Product removed successfully";
	}

	@Override
	public String updateproducts(int productId, Product product) {
		// TODO Auto-generated method stub
		productId = productId-1;
		products.set(productId, product);
		return "Product updated sucessfully..";
	}

}
