package com.khushi.project_alpha_one.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.khushi.project_alpha_one.dto.ProductDTO;
import com.khushi.project_alpha_one.dto.ProductResponse;
import com.khushi.project_alpha_one.exception.NotFoundException;
import com.khushi.project_alpha_one.model.Product;
import com.khushi.project_alpha_one.repo.ProductRepository;


@Service
public class ProductServiceImplementation implements ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	List<Product> products = new ArrayList<>();

	@Override
	public ProductResponse getProducts(int pageNumber, int size) {
		// TODO Auto-generated method stub
		Pageable pageRequest = PageRequest.of(pageNumber, size);
		Page<Product> products = productRepo.findAll(pageRequest);
		
		List<ProductDTO> convertedProduct = products.stream()
				.map(p-> modelMapper.map(p, ProductDTO.class))
				.toList();
		
		ProductResponse productResponse = new ProductResponse();
		
		productResponse.setContent(convertedProduct);
		productResponse.setNumber(products.getNumber());
		productResponse.setSize(products.getSize());
		productResponse.setTotalElement(products.getTotalElements());
		productResponse.setTotalNumberOfElement(products.getNumberOfElements());
		productResponse.setTotalPages(products.getTotalPages());
		productResponse.setLastPage(products.isLast());
		
		return productResponse;
	}

	
	@Override
	public ProductDTO addProducts( ProductDTO productDTO) {
		// TODO Auto-generated method stub
		
		Product addProducts = modelMapper.map(productDTO, Product.class);
		productRepo.save(addProducts);
		ProductDTO addProductDTO = modelMapper.map(addProducts, ProductDTO.class);
		return addProductDTO;
	}

	
	@Override
	public ProductDTO removeproducts( Long productId) {
		// TODO Auto-generated method stub
		Product product = productRepo.findById(productId)
				.orElseThrow(()-> new NotFoundException("Product with id : " + productId + " is not available"));
		productRepo.deleteById(productId);
		ProductDTO removeDTO = modelMapper.map(product, ProductDTO.class);
		return removeDTO;
	}

	
	@Override
	public ProductDTO updateproducts( Long productId, ProductDTO productDTO) {
		// TODO Auto-generated method stub
		Product exisitingProduct = productRepo.findById(productId)
				.orElseThrow(()-> new NotFoundException("Product with id : " + productId + " is not available"));
		
		exisitingProduct.setProductName(productDTO.getProductName());
		exisitingProduct.setProductPrice(productDTO.getProductPrice());
		exisitingProduct.setProductDiscription(productDTO.getProductDiscription());
		exisitingProduct.setProductExp(productDTO.getProductExp());
		
		Product updatedProducts = productRepo.save(exisitingProduct);
		
		ProductDTO updatedProductsDTO = modelMapper.map(updatedProducts, ProductDTO.class);
		
		return updatedProductsDTO;	
	}

	
	@Override
	public ProductDTO getOneProduct(Long productId) {
		// TODO Auto-generated method stub
		Product forOneProduct = productRepo
				.findById(productId)
				.orElseThrow(()-> new NotFoundException("Product with id : " + productId + " is not available"));
		ProductDTO forOneDTO = modelMapper.map(forOneProduct, ProductDTO.class);
		return forOneDTO;
	}
	

	@Override
	public ProductDTO updateProductByName(Long productId, String newName) {
		// TODO Auto-generated method stub
		Product existingName = productRepo.findById(productId)
				.orElseThrow(()-> new NotFoundException("Product with id : " + productId + " is not available"));
		existingName.setProductName(newName);
		
		Product updateByName = productRepo.save(existingName);
		
		ProductDTO updatedNameResponse = modelMapper.map(updateByName, ProductDTO.class);
		
		return updatedNameResponse;
		
	}

	
	@Override
	public ProductResponse getProductByAlpha(String alpha, int pageNumber, int size) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNumber, size);
		Page<Product> productName = productRepo
				.findByProductNameStartingWithIgnoreCase(alpha, pageable);
		
		List<ProductDTO> productList = productName.stream()
				.map(m-> modelMapper.map(m, ProductDTO.class))
				.toList();
		
		ProductResponse responseForAlpha = new ProductResponse();
		
		responseForAlpha.setContent(productList);
		responseForAlpha.setNumber(productName.getNumber());
		responseForAlpha.setSize(productName.getSize());
		responseForAlpha.setTotalElement(productName.getTotalElements());
		responseForAlpha.setTotalNumberOfElement(productName.getNumberOfElements());
		responseForAlpha.setTotalPages(productName.getTotalPages());
		responseForAlpha.setLastPage(productName.isLast());
		
		return responseForAlpha;
	}
	


}
