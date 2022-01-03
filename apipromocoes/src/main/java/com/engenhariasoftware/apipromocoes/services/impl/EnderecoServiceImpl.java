package com.engenhariasoftware.apipromocoes.services.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engenhariasoftware.apipromocoes.domain.Cidade;
import com.engenhariasoftware.apipromocoes.domain.Endereco;
import com.engenhariasoftware.apipromocoes.domain.dtos.EnderecoDTO;
import com.engenhariasoftware.apipromocoes.repositories.EnderecoRepository;
import com.engenhariasoftware.apipromocoes.services.CidadeService;
import com.engenhariasoftware.apipromocoes.services.EnderecoService;
import com.engenhariasoftware.apipromocoes.services.exceptions.ObjectNotFoundException;

@Service
public class EnderecoServiceImpl implements EnderecoService {

	@Autowired
	private EnderecoRepository repository;

	@Autowired
	private CidadeService cidadeService;

	@Override
	public Endereco findById(Integer id) {
		Optional<Endereco> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	@Override
	public List<Endereco> findAll() {
		return repository.findAll();
	}

	@Override
	public Endereco create(@Valid EnderecoDTO objDTO) {
		return repository.save(newEndereco(objDTO));
	}

	@Override
	public Endereco update(Integer id, @Valid EnderecoDTO objDTO) {
		objDTO.setId(id);
		Endereco oldObj = findById(id);
		oldObj = newEndereco(objDTO);
		return repository.save(oldObj);
	}
	
	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	private Endereco newEndereco(EnderecoDTO obj) {
		Cidade cidade = cidadeService.findById(obj.getCidade());
		
		Endereco endereco = new Endereco();
		if(obj.getId() != null) {
			cidade.setId(obj.getId());
		}
		
		endereco.setCidade(cidade);
		endereco.setLogradouro(obj.getLogradouro());
		endereco.setNumero(obj.getNumero());
		endereco.setComplemento(obj.getComplemento());
		endereco.setBairro(obj.getBairro());
		endereco.setCep(obj.getCep());
		return endereco;
	}
	
}
