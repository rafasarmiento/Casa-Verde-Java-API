package com.casaverde.casaverde.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casaverde.casaverde.entities.Client;
import com.casaverde.casaverde.repository.ICLientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ICLientRepository repository;
	
	public Client saveClient(Client client) {
		return repository.save(client);
	}
	
	public List<Client> getClients() {
		return repository.findAll();
		
	}
	
	public Client getClientById(Long id) {
		return repository.findById(id).orElse(null);//si lo encuentra lo deuelve y si no, devuelve 'null'
	}
	
	public String deleteClient(Long id) {
		repository.deleteById(id);
		return "Cliente eliminado: " + id;
	}
	
	public Client modifyClient(Client client) {
		Client oldClient=repository.findById(client.getId()).orElse(null);
		if (oldClient != null) {
			oldClient.setName(client.getName());
			oldClient.setEmail(client.getEmail());
			oldClient.setPhone(client.getPhone());
			oldClient.setBackupPhone(client.getBackupPhone());
			oldClient.setComments(client.getComments());
		} else {
			System.out.println("No se encontro el registro del cliente en la base de datos (no existe)");
			return null;
		}
		return repository.save(oldClient);
	}

}
