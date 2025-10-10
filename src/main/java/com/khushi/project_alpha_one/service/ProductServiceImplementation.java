package com.khushi.project_alpha_one.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
	public ProductResponse getProducts() {
		// TODO Auto-generated method stub
		List<Product> products = productRepo.findAll();
		List<ProductDTO> convertedProduct = products.stream()
				.map(p-> modelMapper.map(p, ProductDTO.class))
				.toList();
		ProductResponse productResponse = new ProductResponse();
		productResponse.setContent(convertedProduct);
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
				.findById(productId).orElseThrow(()-> new NotFoundException("Product with id : " + productId + " is not available"));
		ProductDTO forOneDTO = modelMapper.map(forOneProduct, ProductDTO.class);
		return forOneDTO;
	}
	
	
	

}
