package com.khushi.project_alpha_one.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khushi.project_alpha_one.model.Product;



@RestController
@RequestMapping("api/v1")

public class ProductCotroller {
	
	List<Product> products = new ArrayList<>();
	
	@GetMapping("/viewproducts")
	List<Product> getProducts(){
		return products;
	}
	
	
	@PostMapping("/sendproducts")
	String addProducts(@RequestBody Product product) {
		products.add(product);
		return "Product " + product + " is added in list!";
	}
	
	
	@DeleteMapping("/viewproducts/d/{prodId}")
	String removeproducts(@PathVariable("prodId") int productId){
		productId = productId-1;
		products.remove(productId);
		return "Category removed successfully";
	}
	
	
	@PutMapping("/viewproducts/u/{prodId}")
	String updateproducts(@PathVariable("prodId") int productId, @RequestBody Product product){
		productId = productId-1;
		products.set(productId, product);
		return "Category updated sucessfully..";
	}
	
	
	
	
	
}
