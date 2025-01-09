package com.example.demo.controller;

import java.io.ObjectInputFilter.Status;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> product = productService.getAllProducts();
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		Product product = productService.getProduct(id);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@GetMapping("/{getTypes}")
	public ResponseEntity<List<String>> getProductTypes() {
		List<String> product = productService.getProductTypes();
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Product> createCustomer(@RequestBody Product product) {
		Product savedProduct = productService.createProduct(product);
		ResponseEntity<Product> response = ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
		return response;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
		productService.deleteProduct(id);
		ResponseEntity<Void> response = ResponseEntity.noContent().build();
		return response;
	}

}
