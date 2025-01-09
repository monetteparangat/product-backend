package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Product;

public interface ProductService {

	List<Product> getAllProducts();

	Product getProduct(long id);

	List<String> getProductTypes();

	Product createProduct(Product product);

	void deleteProduct(long id);

}
