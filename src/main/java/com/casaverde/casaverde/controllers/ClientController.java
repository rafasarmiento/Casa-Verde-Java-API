package com.casaverde.casaverde.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.casaverde.casaverde.entities.Client;
import com.casaverde.casaverde.service.ClientService;

@RestController
public class ClientController {

	@Autowired
	private ClientService service;
	
	@RequestMapping(method = RequestMethod.POST, value = "/newClient")
	public Client addClient(@RequestBody Client client) {
		return service.saveClient(client);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteClient/{id}")
	public String removeClient(@PathVariable Long id) {
		return service.deleteClient(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/clients")
	public List<Client> getClients(){
		return service.getClients();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/clients/{id}")
	public Client getClientById(@PathVariable Long id) {
		return service.getClientById(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/editClient")
	public Client modifyClient(@RequestBody Client client) {
		return service.modifyClient(client);
	}
}
