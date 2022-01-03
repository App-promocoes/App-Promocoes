package com.engenhariasoftware.apipromocoes.services.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engenhariasoftware.apipromocoes.domain.Oferta;
import com.engenhariasoftware.apipromocoes.domain.Produto;
import com.engenhariasoftware.apipromocoes.domain.dtos.ProdutoDTO;
import com.engenhariasoftware.apipromocoes.repositories.ProdutoRepository;
import com.engenhariasoftware.apipromocoes.services.OfertaService;
import com.engenhariasoftware.apipromocoes.services.ProdutoService;
import com.engenhariasoftware.apipromocoes.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	@Autowired
	private OfertaService ofertaService;

	@Override
	public Produto findById(Integer id) {
		Optional<Produto> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	@Override
	public List<Produto> findAll() {
		return repository.findAll();
	}

	@Override
	public Produto create(@Valid ProdutoDTO objDTO) {
		return repository.save(newProduto(objDTO));
	}

	@Override
	public Produto update(Integer id, @Valid ProdutoDTO objDTO) {
		objDTO.setId(id);
		Produto oldObj = findById(id);
		oldObj = newProduto(objDTO);
		return repository.save(oldObj);
	}
	
	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	private Produto newProduto(ProdutoDTO obj) {
		Oferta oferta = ofertaService.findById(obj.getOferta());
		
		Produto produto = new Produto();
		if(obj.getId() != null) {
			oferta.setId(obj.getId());
		}
		produto.setOferta(oferta);
		produto.setNome(obj.getNome());
		produto.setValor(obj.getValor());
		produto.setQuantidade(obj.getQuantidade());
		return produto;
	}
	
}
