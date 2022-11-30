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

import com.hamburgueria.dao.RequestRepository;
import com.hamburgueria.model.Request;


@RestController
@RequestMapping({"hamburgueria/orders"})
public class RequestController {

	
	@Autowired
	private RequestRepository repository;

	@GetMapping
	public List<Request> findAll(){
		return repository.findAll();
	}

	@GetMapping(path = {"/{id}"})
	public Optional<Request> findById(@PathVariable long id){
		return repository.findById(id);
	}

	@PostMapping
	public Request create(@RequestBody Request order){
		return repository.save(order);
	}

	@PutMapping
	public Request update(@RequestBody Request order){
		return repository.save(order);
	}	

	@DeleteMapping(path ={"/{id}"})
	public void delete(@PathVariable("id") long id) {
		repository.deleteById(id);
	}
}