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

import com.hamburgueria.dao.ClientRepository;
import com.hamburgueria.model.Client;


@RestController
@RequestMapping({"hamburgueria/clients"})
public class ClientController {

	
	@Autowired
	private ClientRepository repository;

	@GetMapping
	public List<Client> findAll(){
		return repository.findAll();
	}

	@GetMapping(path = {"/{id}"})
	public Optional<Client> findById(@PathVariable long id){
		return repository.findById(id);
	}

	@PostMapping
	public Client create(@RequestBody Client client){
		return repository.save(client);
	}

	@PutMapping
	public Client update(@RequestBody Client client){
		return repository.save(client);
	}	

	@DeleteMapping(path ={"/{id}"})
	public void delete(@PathVariable("id") long id) {
		repository.deleteById(id);
	}
}
