package com.engenhariasoftware.apipromocoes.services;

import java.util.List;

import com.engenhariasoftware.apipromocoes.domain.Cliente;
import com.engenhariasoftware.apipromocoes.domain.dtos.ClienteDTO;

public interface ClienteService {

	Cliente findById(Integer id);
	List<Cliente> findAll();
	Cliente create(ClienteDTO obj); 
	Cliente update(Integer id, ClienteDTO obj);
	void delete(Integer id);
	
}
