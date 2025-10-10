package com.khushi.project_alpha_one.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
@Getter
@Setter
public class ProductDTO {
	
	private Long productId;
	private String productName;
	private String productDiscription;
	private Long productPrice;
	private LocalDate productExp;

}
