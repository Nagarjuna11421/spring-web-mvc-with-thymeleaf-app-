package com.spring.web.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Order {

	private Integer oId;
	private String orderName;
	private LocalDate orderDate;
	
}
