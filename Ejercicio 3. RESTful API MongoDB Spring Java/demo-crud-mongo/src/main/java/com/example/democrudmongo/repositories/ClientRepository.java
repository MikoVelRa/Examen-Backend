package com.example.democrudmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.democrudmongo.model.Cliente;

@Repository
public interface ClientRepository extends MongoRepository<Cliente, Integer>{
	
}
