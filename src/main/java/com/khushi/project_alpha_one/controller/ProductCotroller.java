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

import com.khushi.project_alpha_one.dto.ProductDTO;
import com.khushi.project_alpha_one.dto.ProductResponse;
import com.khushi.project_alpha_one.model.Product;
import com.khushi.project_alpha_one.service.ProductService;

@RestController
@RequestMapping("api/v1")

public class ProductCotroller {
	
	//Dependency Injection
	
	@Autowired
	private ProductService productService;
	
	
	@GetMapping("/viewproducts")
	ResponseEntity<ProductResponse> getProducts(){
		ProductResponse item = productService.getProducts();
		return ResponseEntity.ok().body(item);
	}
	
	
	@GetMapping("/view-one-product/{prodId}")
	ResponseEntity<ProductDTO> getOneProduct(@PathVariable("prodId") Long productId){
		ProductDTO viewOneItem = productService.getOneProduct(productId);
		return ResponseEntity.ok().body(viewOneItem);
	}
	
	
	@PostMapping("/sendproducts")
	ResponseEntity<ProductDTO> addProducts(@RequestBody ProductDTO productDTO) {
		ProductDTO addeditem = productService.addProducts(productDTO);
		return ResponseEntity.accepted().body(addeditem);
	}
	
	
	@DeleteMapping("/viewproducts/d/{prodId}")
	ResponseEntity<ProductDTO> removeproducts(@PathVariable("prodId") Long productId){
		ProductDTO deletedItem = productService.removeproducts(productId);
		return ResponseEntity.ok().body(deletedItem);
	}
	
	
	@PutMapping("/viewproducts/u/{prodId}")
	ResponseEntity<ProductDTO> updateproducts(@PathVariable("prodId") Long productId, @RequestBody ProductDTO productDTO){
		ProductDTO updatedItem = productService.updateproducts(productId, productDTO);
		return ResponseEntity.ok().body(updatedItem);
	}
	
	
	
	
	
}
