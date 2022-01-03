package com.engenhariasoftware.apipromocoes.services.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engenhariasoftware.apipromocoes.domain.Cidade;
import com.engenhariasoftware.apipromocoes.domain.Estado;
import com.engenhariasoftware.apipromocoes.domain.dtos.CidadeDTO;
import com.engenhariasoftware.apipromocoes.repositories.CidadeRepository;
import com.engenhariasoftware.apipromocoes.services.CidadeService;
import com.engenhariasoftware.apipromocoes.services.EstadoService;
import com.engenhariasoftware.apipromocoes.services.exceptions.DataIntegratyViolationException;
import com.engenhariasoftware.apipromocoes.services.exceptions.ObjectNotFoundException;

@Service
public class CidadeServiceImpl implements CidadeService {

	@Autowired
	private CidadeRepository repository;

	@Autowired
	private EstadoService estadoService;

	@Override
	public Cidade findById(Integer id) {
		Optional<Cidade> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	@Override
	public List<Cidade> findAll() {
		return repository.findAll();
	}

	@Override
	public Cidade create(@Valid CidadeDTO objDTO) {
		validarNomeCidade(objDTO);
		return repository.save(newCidade(objDTO));
	}

	@Override
	public Cidade update(Integer id, @Valid CidadeDTO objDTO) {
		objDTO.setId(id);
		validarNomeCidade(objDTO);
		Cidade oldObj = findById(id);
		oldObj = newCidade(objDTO);
		return repository.save(oldObj);
	}
	
	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	private Cidade newCidade(CidadeDTO obj) {
		Estado estado = estadoService.findById(obj.getEstado());
		
		Cidade cidade = new Cidade();
		if(obj.getId() != null) {
			cidade.setId(obj.getId());
		}
		
		cidade.setEstado(estado);
		cidade.setNome(obj.getNome());
		return cidade;
	}

	private void validarNomeCidade(CidadeDTO objDTO) {
		Optional<Cidade> cidade = repository.findByNome(objDTO.getNome());
		if (cidade.isPresent()) {
			throw new DataIntegratyViolationException("Cidade já cadastrado no sistema");
		}
	}
	
}
