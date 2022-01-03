package com.engenhariasoftware.apipromocoes.services.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engenhariasoftware.apipromocoes.domain.Categoria;
import com.engenhariasoftware.apipromocoes.domain.dtos.CategoriaDTO;
import com.engenhariasoftware.apipromocoes.repositories.CategoriaRepository;
import com.engenhariasoftware.apipromocoes.services.CategoriaService;
import com.engenhariasoftware.apipromocoes.services.exceptions.DataIntegratyViolationException;
import com.engenhariasoftware.apipromocoes.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	@Override
	public Categoria findById(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	@Override
	public List<Categoria> findAll() {
		return repository.findAll();
	}

	@Override
	public Categoria create(@Valid CategoriaDTO objDTO) {
		validarNomeCategoria(objDTO);
		return repository.save(newCategoria(objDTO));
	}

	@Override
	public Categoria update(Integer id, @Valid CategoriaDTO objDTO) {
		objDTO.setId(id);
		validarNomeCategoria(objDTO);
		Categoria oldObj = findById(id);
		oldObj = newCategoria(objDTO);
		return repository.save(oldObj);
	}
	
	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	private Categoria newCategoria(CategoriaDTO obj) {
		
		Categoria categoria = new Categoria();
		if(obj.getId() != null) {
			categoria.setId(obj.getId());
		}
		categoria.setNome(obj.getNome());
		return categoria;
	}

	private void validarNomeCategoria(CategoriaDTO objDTO) {
		Optional<Categoria> categoria = repository.findByNome(objDTO.getNome());
		if (categoria.isPresent()) {
			throw new DataIntegratyViolationException("Categoria já cadastrado no sistema");
		}
	}
	
}
