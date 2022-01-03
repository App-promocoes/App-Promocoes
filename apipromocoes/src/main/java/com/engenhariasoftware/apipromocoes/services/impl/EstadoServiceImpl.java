package com.engenhariasoftware.apipromocoes.services.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engenhariasoftware.apipromocoes.domain.Estado;
import com.engenhariasoftware.apipromocoes.domain.dtos.EstadoDTO;
import com.engenhariasoftware.apipromocoes.repositories.EstadoRepository;
import com.engenhariasoftware.apipromocoes.services.EstadoService;
import com.engenhariasoftware.apipromocoes.services.exceptions.DataIntegratyViolationException;
import com.engenhariasoftware.apipromocoes.services.exceptions.ObjectNotFoundException;

@Service
public class EstadoServiceImpl implements EstadoService {

	@Autowired
	private EstadoRepository repository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public Estado findById(Integer id) {
		Optional<Estado> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	@Override
	public List<Estado> findAll() {
		return repository.findAll();
	}

	@Override
	public Estado create(@Valid EstadoDTO obj) {
		findByNome(obj);
		return repository.save(mapper.map(obj, Estado.class));
	}

	@Override
	public Estado update(@Valid EstadoDTO obj) {
		return repository.save(mapper.map(obj, Estado.class));
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	private void findByNome(EstadoDTO obj) {
		Optional<Estado> estado = repository.findByNome(obj.getNome());
		if (estado.isPresent()) {
			throw new DataIntegratyViolationException("Estado já cadastrado no sistema");
		}
	}

}
