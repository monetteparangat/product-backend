package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub

		List<Product> products = productRepository.findAll();
		return products;
	}

	@Override
	public Product getProduct(long id) {
		// TODO Auto-generated method stub
		Product product = productRepository.findById(id).orElse(null);
		return product;
	}

	@Override
	public List<String> getProductTypes() {
		List<String> productTypes = productRepository.findAll().stream().map(Product::getType).distinct().toList();
		return productTypes;
	}

	@Override
	public Product createProduct(Product product) {
		Product savedProduct = productRepository.save(product);
		return savedProduct;
	}

	@Override
	public void deleteProduct(long id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);

	}

}
