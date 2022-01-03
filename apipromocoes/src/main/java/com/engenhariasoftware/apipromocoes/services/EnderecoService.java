package com.engenhariasoftware.apipromocoes.services;

import java.util.List;

import com.engenhariasoftware.apipromocoes.domain.Endereco;
import com.engenhariasoftware.apipromocoes.domain.dtos.EnderecoDTO;

public interface EnderecoService {

	Endereco findById(Integer id);
	List<Endereco> findAll();
	Endereco create(EnderecoDTO obj); 
	Endereco update(Integer id, EnderecoDTO obj);
	void delete(Integer id);
	
}
