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

}
