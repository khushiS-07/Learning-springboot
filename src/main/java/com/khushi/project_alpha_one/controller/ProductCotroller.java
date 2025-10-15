package com.khushi.project_alpha_one.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.khushi.project_alpha_one.dto.ProductDTO;
import com.khushi.project_alpha_one.dto.ProductResponse;
import com.khushi.project_alpha_one.service.ProductService;

@RestController
@RequestMapping("api/v1")

public class ProductCotroller {
	
	//Dependency Injection
	
	@Autowired
	private ProductService productService;
	
	
	@GetMapping("/viewproducts")
	ResponseEntity<ProductResponse> getProducts(
			@RequestParam(name ="pn" , defaultValue = "0") int pageNumber,
			@RequestParam(name = "s" , defaultValue = "10" ) int size
			){
		ProductResponse item = productService.getProducts(pageNumber , size);
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
	
	
	@PatchMapping("/view-updated-name/p/{prodId}")
	ResponseEntity<ProductDTO> updateProductByName(@PathVariable("prodId") Long productId, @RequestParam("name") String newName){
		ProductDTO updatedName = productService.updateProductByName(productId, newName);
		return ResponseEntity.ok().body(updatedName);
	}
	
	
	@GetMapping("/products/product")
	ResponseEntity<ProductResponse> getProductByAlpha(
			@RequestParam(name = "alpha") String alpha,
			@RequestParam(name ="pn" , defaultValue = "0") int pageNumber,
			@RequestParam(name = "s" , defaultValue = "10" ) int size
			){
		ProductResponse productAlpha = productService.getProductByAlpha(alpha, pageNumber, size);
		return ResponseEntity.ok().body(productAlpha);
	}
	
	
	
}
