package com.engenhariasoftware.apipromocoes.services;

import java.util.List;

import com.engenhariasoftware.apipromocoes.domain.Oferta;
import com.engenhariasoftware.apipromocoes.domain.dtos.OfertaDTO;

public interface OfertaService {

	Oferta findById(Integer id);
	List<Oferta> findAll();
	Oferta create(OfertaDTO obj); 
	Oferta update(Integer id, OfertaDTO obj);
	void delete(Integer id);
	
}
