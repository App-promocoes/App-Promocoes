package com.engenhariasoftware.apipromocoes.services;

import java.util.List;

import com.engenhariasoftware.apipromocoes.domain.Estado;
import com.engenhariasoftware.apipromocoes.domain.dtos.EstadoDTO;

public interface EstadoService {

	Estado findById(Integer id);
	List<Estado> findAll();
	Estado create(EstadoDTO obj); 
	Estado update(EstadoDTO obj);
	void delete(Integer id);   
	
}
