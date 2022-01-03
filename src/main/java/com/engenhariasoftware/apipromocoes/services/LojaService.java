package com.engenhariasoftware.apipromocoes.services;

import java.util.List;

import com.engenhariasoftware.apipromocoes.domain.Loja;
import com.engenhariasoftware.apipromocoes.domain.dtos.LojaDTO;

public interface LojaService {

	Loja findById(Integer id);
	List<Loja> findAll();
	Loja create(LojaDTO obj); 
	Loja update(Integer id, LojaDTO obj);
	void delete(Integer id);
	
}
