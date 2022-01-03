package com.engenhariasoftware.apipromocoes.services.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engenhariasoftware.apipromocoes.domain.Cliente;
import com.engenhariasoftware.apipromocoes.domain.Endereco;
import com.engenhariasoftware.apipromocoes.domain.Loja;
import com.engenhariasoftware.apipromocoes.domain.Oferta;
import com.engenhariasoftware.apipromocoes.domain.dtos.LojaDTO;
import com.engenhariasoftware.apipromocoes.repositories.LojaRepository;
import com.engenhariasoftware.apipromocoes.services.ClienteService;
import com.engenhariasoftware.apipromocoes.services.EnderecoService;
import com.engenhariasoftware.apipromocoes.services.LojaService;
import com.engenhariasoftware.apipromocoes.services.OfertaService;
import com.engenhariasoftware.apipromocoes.services.exceptions.DataIntegratyViolationException;
import com.engenhariasoftware.apipromocoes.services.exceptions.ObjectNotFoundException;

@Service
public class LojaServiceImpl implements LojaService {

	@Autowired
	private LojaRepository repository;

	@Autowired
	private EnderecoService enderecoService;

	@Autowired
	private OfertaService ofertaService;

	@Autowired
	private ClienteService clienteService;

	@Override
	public Loja findById(Integer id) {
		Optional<Loja> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	@Override
	public List<Loja> findAll() {
		return repository.findAll();
	}

	@Override
	public Loja create(@Valid LojaDTO objDTO) {
		validarPorCnpj(objDTO);
		return repository.save(newLoja(objDTO));
	}

	@Override
	public Loja update(Integer id, @Valid LojaDTO objDTO) {
		objDTO.setId(id);
		Loja oldObj = findById(id);
		oldObj = newLoja(objDTO);
		return repository.save(oldObj);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	private Loja newLoja(LojaDTO obj) {
		Endereco endereco = enderecoService.findById(obj.getEndereco());
		Oferta oferta = ofertaService.findById(obj.getOferta());
		Cliente cliente = clienteService.findById(obj.getCliente());

		Loja loja = new Loja();
		if (obj.getId() != null) {
			loja.setId(obj.getId());
		}

		loja.setCliente(cliente);
		loja.setEndereco(endereco);
		loja.setOferta(oferta);
		loja.setNome(obj.getNome());
		loja.setCnpj(obj.getCnpj());
		loja.setTelefone(obj.getTelefone());
		return loja;
	}

	private void validarPorCnpj(@Valid LojaDTO objDTO) {
		Optional<Loja> obj = repository.findByCnpj(objDTO.getCnpj());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegratyViolationException("CNPJ já cadastrado no sistema!");
		}

	}

}
