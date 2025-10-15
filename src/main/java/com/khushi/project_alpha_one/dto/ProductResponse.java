package com.khushi.project_alpha_one.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ProductResponse {
	
	private List<ProductDTO> content;
	private Long totalElement; 
	private int totalPages;
	private int size;
	private int number;
	private int totalNumberOfElement;
	private boolean isLastPage;

}
