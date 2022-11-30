package com.hamburgueria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hamburgueria.dao.ProductRepository;
import com.hamburgueria.model.Product;


@RestController
@RequestMapping({"hamburgueria/products"})
public class ProductController {

	
	@Autowired
	private ProductRepository repository;

	@GetMapping
	public List<Product> findAll(){
		return repository.findAll();
	}

	@GetMapping(path = {"/{id}"})
	public Optional<Product> findById(@PathVariable long id){
		return repository.findById(id);
	}

	@PostMapping
	public Product create(@RequestBody Product product){
		return repository.save(product);
	}

	@PutMapping
	public Product update(@RequestBody Product product){
		return repository.save(product);
	}	

	@DeleteMapping(path ={"/{id}"})
	public void delete(@PathVariable("id") long id) {
		repository.deleteById(id);
	}
}
