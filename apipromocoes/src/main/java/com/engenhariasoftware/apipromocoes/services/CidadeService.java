package com.engenhariasoftware.apipromocoes.services;

import java.util.List;

import com.engenhariasoftware.apipromocoes.domain.Cidade;
import com.engenhariasoftware.apipromocoes.domain.dtos.CidadeDTO;

public interface CidadeService {

	Cidade findById(Integer id);
	List<Cidade> findAll();
	Cidade create(CidadeDTO obj); 
	Cidade update(Integer id, CidadeDTO obj);
	void delete(Integer id);
	
}
