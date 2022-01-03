package com.engenhariasoftware.apipromocoes.services.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engenhariasoftware.apipromocoes.domain.Oferta;
import com.engenhariasoftware.apipromocoes.domain.dtos.OfertaDTO;
import com.engenhariasoftware.apipromocoes.repositories.OfertaRepository;
import com.engenhariasoftware.apipromocoes.services.OfertaService;
import com.engenhariasoftware.apipromocoes.services.exceptions.DataIntegratyViolationException;
import com.engenhariasoftware.apipromocoes.services.exceptions.ObjectNotFoundException;

@Service
public class OfertaServiceImpl implements OfertaService {

	@Autowired
	private OfertaRepository repository;

	@Override
	public Oferta findById(Integer id) {
		Optional<Oferta> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	@Override
	public List<Oferta> findAll() {
		return repository.findAll();
	}

	@Override
	public Oferta create(@Valid OfertaDTO objDTO) {
		validarNomeOferta(objDTO);
		return repository.save(newOferta(objDTO));
	}

	@Override
	public Oferta update(Integer id, @Valid OfertaDTO objDTO) {
		objDTO.setId(id);
		validarNomeOferta(objDTO);
		Oferta oldObj = findById(id);
		oldObj = newOferta(objDTO);
		return repository.save(oldObj);
	}
	
	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	private Oferta newOferta(OfertaDTO obj) {
		Oferta cat = new Oferta(); 
		if(obj.getId() != null) {
			cat.setId(obj.getId());
		}
		
		cat.setNome(obj.getNome());
		cat.setPrecoOferta(obj.getPrecoOferta());
		return cat;
	}

	private void validarNomeOferta(OfertaDTO objDTO) {
		Optional<Oferta> oferta = repository.findByNome(objDTO.getNome());
		if (oferta.isPresent()) {
			throw new DataIntegratyViolationException("Oferta já cadastrado no sistema");
		}
	}
	
}
