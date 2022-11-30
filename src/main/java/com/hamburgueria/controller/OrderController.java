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

import com.hamburgueria.dao.OrderRepository;
import com.hamburgueria.model.Order;


@RestController
@RequestMapping({"hamburgueria/orders"})
public class OrderController {

	
	@Autowired
	private OrderRepository repository;

	@GetMapping
	public List<Order> findAll(){
		return repository.findAll();
	}

	@GetMapping(path = {"/{id}"})
	public Optional<Order> findById(@PathVariable long id){
		return repository.findById(id);
	}

	@PostMapping
	public Order create(@RequestBody Order order){
		return repository.save(order);
	}

	@PutMapping
	public Order update(@RequestBody Order order){
		return repository.save(order);
	}	

	@DeleteMapping(path ={"/{id}"})
	public void delete(@PathVariable("id") long id) {
		repository.deleteById(id);
	}
}
