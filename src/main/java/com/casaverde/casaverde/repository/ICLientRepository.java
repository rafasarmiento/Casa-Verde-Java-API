package com.casaverde.casaverde.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casaverde.casaverde.entities.Client;

public interface ICLientRepository extends JpaRepository<Client, Long> {
	
}
