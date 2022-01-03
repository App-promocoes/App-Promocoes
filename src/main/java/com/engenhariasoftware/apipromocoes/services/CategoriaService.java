package com.engenhariasoftware.apipromocoes.services;

import java.util.List;

import com.engenhariasoftware.apipromocoes.domain.Categoria;
import com.engenhariasoftware.apipromocoes.domain.dtos.CategoriaDTO;

public interface CategoriaService {

	Categoria findById(Integer id);
	List<Categoria> findAll();
	Categoria create(CategoriaDTO obj); 
	Categoria update(Integer id, CategoriaDTO obj);
	void delete(Integer id);
	
}
