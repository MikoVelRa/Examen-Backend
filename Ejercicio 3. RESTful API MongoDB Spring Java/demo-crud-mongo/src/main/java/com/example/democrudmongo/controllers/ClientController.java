package com.example.democrudmongo.controllers;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.democrudmongo.model.Cliente;
import com.example.democrudmongo.repositories.ClientRepository;

@RestController
public class ClientController {
	
	@Autowired
	public ClientRepository clientRepository;
	
	@GetMapping(value = "/NutriNET/Cliente")
	public List<Cliente> getAllClients() {
		return clientRepository.findAll();
	}
	
	@GetMapping(value = "/NutriNET/Cliente/{id}")
	public String getClientById(@PathVariable("id") Integer id){
		Optional<Cliente> client = clientRepository.findById(id);
		
		if(client.isPresent()) {
			return "Cliente: " + client.get();
		} else {
			return " Cliente no enocntrado " + HttpStatus.NOT_FOUND;
		}
	}
	
	@PostMapping(value = "/NutriNET/Cliente")
	public String createClient(@RequestBody Cliente cliente){
		
		System.out.print("Cliente: " + cliente.getNombre());
		
		Cliente clienteInsertado = clientRepository.save(cliente);
		
		return "Cliente creado exitosamente. " + clienteInsertado.getNombre();
	}
	
	@PutMapping("/tutorials/{id}")
	public ResponseEntity<Cliente> updateClient(@PathVariable("id") Integer id, @RequestBody Cliente cliente) {
	  Optional<Cliente> clientData = clientRepository.findById(id);

	  if (clientData.isPresent()) {
	    Cliente client = clientData.get();
	    client.setNombre_Usuario(cliente.getNombre_Usuario());
	    client.setContraseña(client.getContraseña());
	    client.setNombre(client.getNombre());
	    client.setApellidos(client.getApellidos());
	    client.setCorreo_Electronico(client.getCorreo_Electronico());
	    client.setEdad(client.getEdad());
	    client.setEstatura(client.getEstatura());
	    client.setPeso(client.getPeso());
	    client.setIMC(client.getIMC());
	    client.setGEB(client.getGEB());
	    client.setETA(client.getETA());		
	    client.setFecha_Actualizacion(LocalDate.now().toString());
	    return new ResponseEntity<>(clientRepository.save(client), HttpStatus.OK);
	  } else {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
	}

}
