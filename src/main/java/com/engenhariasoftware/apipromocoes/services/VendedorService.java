package com.engenhariasoftware.apipromocoes.services;

import java.util.List;

import com.engenhariasoftware.apipromocoes.domain.Vendedor;
import com.engenhariasoftware.apipromocoes.domain.dtos.VendedorDTO;

public interface VendedorService {

	Vendedor findById(Integer id);
	List<Vendedor> findAll();
	Vendedor create(VendedorDTO obj); 
	Vendedor update(Integer id, VendedorDTO obj);
	void delete(Integer id);
	
}
