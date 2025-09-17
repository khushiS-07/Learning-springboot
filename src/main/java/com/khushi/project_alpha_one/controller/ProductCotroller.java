package com.khushi.project_alpha_one.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khushi.project_alpha_one.model.Product;
import com.khushi.project_alpha_one.service.ProductService;

@RestController
@RequestMapping("api/v1")

public class ProductCotroller {
	
	//Dependency Injection
	
	@Autowired
	private ProductService productService;
	
	
	@GetMapping("/viewproducts")
	List<Product> getProducts(){
		return productService.getProducts();
	}
	
	
	@PostMapping("/sendproducts")
	String addProducts(@RequestBody Product product) {
		String message = productService.addProducts(product);
		return message;
	}
	
	
	@DeleteMapping("/viewproducts/d/{prodId}")
	String removeproducts(@PathVariable("prodId") int productId){
		String message = productService.removeproducts(productId);
		return message;
	}
	
	
	@PutMapping("/viewproducts/u/{prodId}")
	String updateproducts(@PathVariable("prodId") int productId, @RequestBody Product product){
		String message = productService.updateproducts(productId, product);
		return message;
	}
	
	
	
	
	
}
