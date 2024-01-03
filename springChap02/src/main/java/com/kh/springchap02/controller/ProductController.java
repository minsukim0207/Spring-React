package com.kh.springchap02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.springchap02.model.Product;
import com.kh.springchap02.service.ProductService;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins="http://localhost:3000", allowCredentials="true", allowedHeaders="*")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/item")
	public ResponseEntity<List<Product>> getAllProduct() {
		List<Product> products = productService.getAllProduct();
		return ResponseEntity.ok(products);
	}
}
