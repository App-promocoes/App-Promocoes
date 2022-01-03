package com.engenhariasoftware.apipromocoes.services;

import java.util.List;

import com.engenhariasoftware.apipromocoes.domain.Produto;
import com.engenhariasoftware.apipromocoes.domain.dtos.ProdutoDTO;

public interface ProdutoService {

	Produto findById(Integer id);
	List<Produto> findAll();
	Produto create(ProdutoDTO obj); 
	Produto update(Integer id, ProdutoDTO obj);
	void delete(Integer id);
	
}
