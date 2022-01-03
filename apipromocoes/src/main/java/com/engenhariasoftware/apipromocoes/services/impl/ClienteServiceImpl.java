package com.engenhariasoftware.apipromocoes.services.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.engenhariasoftware.apipromocoes.domain.Cliente;
import com.engenhariasoftware.apipromocoes.domain.Endereco;
import com.engenhariasoftware.apipromocoes.domain.dtos.ClienteDTO;
import com.engenhariasoftware.apipromocoes.repositories.ClienteRepository;
import com.engenhariasoftware.apipromocoes.services.ClienteService;
import com.engenhariasoftware.apipromocoes.services.EnderecoService;
import com.engenhariasoftware.apipromocoes.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Autowired
	private EnderecoService enderecoService;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public Cliente findById(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	@Override
	public List<Cliente> findAll() {
		return repository.findAll();
	}

	@Override
	public Cliente create(ClienteDTO objDTO) {
		objDTO.setSenha(encoder.encode(objDTO.getSenha()));
		return repository.save(newCliente(objDTO));
	}

	@Override
	public Cliente update(Integer id, @Valid ClienteDTO objDTO) {
		objDTO.setId(id);
		Cliente oldObj = findById(id);
		oldObj = newCliente(objDTO);
		return repository.save(oldObj);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	private Cliente newCliente(ClienteDTO obj) {
		Endereco endereco = enderecoService.findById(obj.getEndereco());

		Cliente cliente = new Cliente();
		if (obj.getId() != null) {
			cliente.setId(obj.getId());
		}

		cliente.setEndereco(endereco);
		cliente.setNome(obj.getNome());
		cliente.setCpf(obj.getCpf());
		cliente.setDataCriacao(obj.getDataCriacao());
		cliente.setEmail(obj.getEmail());
		cliente.setSenha(obj.getSenha());
		return cliente;
	}

}
