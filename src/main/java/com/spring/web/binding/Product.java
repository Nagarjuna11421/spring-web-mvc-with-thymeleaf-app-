package com.spring.web.binding;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Product {

	@NotNull(message = "Id is required")
	//@Size(min = 1, max =2)
	private Integer pid;
	
	
	@NotBlank(message = "product name should not be empty")
	@Size(min = 3, max = 10)
	private String productName;
	
	@NotNull(message = "price should not be empty")
	//@Size(min = 5, max = 6)
	private Double price;
}
