package com.hamburgueria.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hamburgueria.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
