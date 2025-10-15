package com.khushi.project_alpha_one.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.khushi.project_alpha_one.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	void deleteById(Long id);

	Page<Product> findByProductNameStartingWithIgnoreCase(String alpha, Pageable pageable);

}
