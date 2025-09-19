package com.khushi.project_alpha_one.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	ResponseEntity<List<Product>> getProducts(){
		List<Product> item = productService.getProducts();
		return ResponseEntity.ok().body(item);
	}
	
	
	@PostMapping("/sendproducts")
	ResponseEntity<String> addProducts(@RequestBody Product product) {
		String addeditem = productService.addProducts(product);
		return ResponseEntity.accepted().body(addeditem);
	}
	
	
	@DeleteMapping("/viewproducts/d/{prodId}")
	ResponseEntity<String> removeproducts(@PathVariable("prodId") int productId){
		String deletedItem = productService.removeproducts(productId);
		return ResponseEntity.ok().body(deletedItem);
	}
	
	
	@PutMapping("/viewproducts/u/{prodId}")
	ResponseEntity<String> updateproducts(@PathVariable("prodId") int productId, @RequestBody Product product){
		String updatedItem = productService.updateproducts(productId, product);
		return ResponseEntity.ok().body(updatedItem);
	}
	
	
	
	
	
}
