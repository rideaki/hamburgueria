package com.hamburgueria.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.hamburgueria.dao.RequestRepository;
import com.hamburgueria.model.Request;


@RestController
@RequestMapping({"hamburgueria/requests"})
public class RequestController {

	Logger logger = LoggerFactory.getLogger(RequestController.class);
	
	@Autowired
	private RequestRepository repository;
	
	@Autowired
	private ProductRepository productRepository;

	@GetMapping
	public List<Request> findAll(){
		return repository.findAll();
	}

	@GetMapping(path = {"/{id}"})
	public Optional<Request> findById(@PathVariable long id){
		return repository.findById(id);
	}

	@PostMapping
	public Request create(@RequestBody Request request){
		if (request == null || request.getProducts() == null || request.getProducts().isEmpty()) {
			logger.warn("PEDIDO SEM PRODUTO!");
			return repository.save(request);
		}
		request.getProducts().forEach(product -> {
			if (product == null) {
				logger.error("PEDIDO COM PRODUTO INVÁLIDO!!!!!!!!!!");
				return;
			} else {
				if(!productRepository.existsById(product.getId())) {
					logger.error("PRODUTO NÃO ENCONTRADO! É NECESSÁRIO CADASTRAR O PRODUTO ANTES DE FAZER O PEDIDO!!!!!!!!!");
					return;
				}
			}
		});
		return repository.save(request);
	}

	@PutMapping
	public Request update(@RequestBody Request request){
		if (request == null || request.getProducts() == null || request.getProducts().isEmpty()) {
			logger.warn("PEDIDO SEM PRODUTO!");
			return repository.save(request);
		}
		request.getProducts().forEach(product -> {
			if (product == null) {
				logger.error("PEDIDO COM PRODUTO INVÁLIDO!!!!!!!!!!");
				return;
			} else {
				if(!productRepository.existsById(product.getId())) {
					logger.error("PRODUTO NÃO ENCONTRADO! É NECESSÁRIO CADASTRAR O PRODUTO ANTES DE FAZER O PEDIDO!!!!!!!!!");
					return;
				}
			}
		});
		return repository.save(request);
	}	

	@DeleteMapping(path ={"/{id}"})
	public void delete(@PathVariable("id") long id) {
		repository.deleteById(id);
	}
}
