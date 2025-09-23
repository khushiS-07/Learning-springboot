package com.khushi.project_alpha_one.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.khushi.project_alpha_one.exception.NotFoundException;
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
		Long id = Long.valueOf(productId);
		Product removed = findIdOrThrow(id);
		products.remove(removed);
		return "Product removed successfully with id : " + productId;
	}

	@Override
	public String updateproducts(int productId, Product product) {
		// TODO Auto-generated method stub
		Long id = Long.valueOf(productId);
		Product updated = findIdOrThrow(id);
		int index = products.indexOf(updated);
		products.set(index, product);
		return "Product updated sucessfully..";
	}
	
	
	
	// Helper Method
	
	private Product findIdOrThrow(Long id) {
		Optional<Product> opt = products.stream()
				.filter(c-> c.getProductId() != null && c.getProductId().equals(id))
				.findFirst();
		
		return opt.orElseThrow(()->
		new NotFoundException("Product with id " + id + " not found"));
	}
	

}
