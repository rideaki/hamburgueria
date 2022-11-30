package com.hamburgueria.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hamburgueria.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
