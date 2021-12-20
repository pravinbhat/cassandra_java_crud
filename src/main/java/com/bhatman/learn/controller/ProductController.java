package com.bhatman.learn.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bhatman.learn.model.Product;
import com.bhatman.learn.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/product")
	public Product product(@RequestParam(value = "prod-id", defaultValue = "prd-1") UUID prodId) {
		return productService.getProductById(prodId);
		//return new Product(prodId, "", "Prod-1-desc", "dim-1", "loc-1", "Prod-1", "", 12.34);
	}

}
