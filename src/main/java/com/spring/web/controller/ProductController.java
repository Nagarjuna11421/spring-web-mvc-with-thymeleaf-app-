package com.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.web.binding.Product;

import jakarta.validation.Valid;

@Controller
public class ProductController {

	
	@GetMapping("/")
	public String loadForm(Model model) {
		model.addAttribute("product",new Product());
		return "productfile";
	}

	
	@PostMapping("/save")
	public String handleSubmitForm(@Valid Product product, BindingResult bindingResult, Model model) {
		
		System.out.println(product);
		if(bindingResult.hasErrors()) {
			return "productfile";
		}
		else {
		model.addAttribute("message","product saved successfully.");
		}
		return "display";
	}
}
