package com.springproject.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.crud.model.Product;
import com.springproject.crud.repository.ProductRepository;
@Service
public class ProductService {
	@Autowired
	private ProductRepository repo;
	
	
	public List<Product> listAll(){
		return (List<Product>) repo.findAll();
	}
	public void save(Product product) {
 repo.save(product);
	}
	public Product get(Long id) {
		return repo.findById(id).get();
	}
public void delete (Long id) {
	repo.deleteById(id);
}
}
