package com.engenhariasoftware.apipromocoes.services.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.engenhariasoftware.apipromocoes.domain.Endereco;
import com.engenhariasoftware.apipromocoes.domain.Pessoa;
import com.engenhariasoftware.apipromocoes.domain.Vendedor;
import com.engenhariasoftware.apipromocoes.domain.dtos.VendedorDTO;
import com.engenhariasoftware.apipromocoes.repositories.PessoaRepository;
import com.engenhariasoftware.apipromocoes.repositories.VendedorRepository;
import com.engenhariasoftware.apipromocoes.services.EnderecoService;
import com.engenhariasoftware.apipromocoes.services.VendedorService;
import com.engenhariasoftware.apipromocoes.services.exceptions.DataIntegratyViolationException;
import com.engenhariasoftware.apipromocoes.services.exceptions.ObjectNotFoundException;

@Service
public class VendedorServiceImpl implements VendedorService {

	@Autowired
	private VendedorRepository repository;

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private EnderecoService enderecoService;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public Vendedor findById(Integer id) {
		Optional<Vendedor> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	@Override
	public List<Vendedor> findAll() {
		return repository.findAll();
	}

	@Override
	public Vendedor create(VendedorDTO objDTO) {
		objDTO.setSenha(encoder.encode(objDTO.getSenha()));
		validaPorCpfEEmail(objDTO);
		return repository.save(newVendedor(objDTO));
	}

	@Override
	public Vendedor update(Integer id, @Valid VendedorDTO objDTO) {
		objDTO.setId(id);
		Vendedor oldObj = findById(id);
		oldObj = newVendedor(objDTO);
		return repository.save(oldObj);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	private Vendedor newVendedor(VendedorDTO obj) {
		Endereco endereco = enderecoService.findById(obj.getEndereco());

		Vendedor vendedor = new Vendedor();
		if (obj.getId() != null) {
			vendedor.setId(obj.getId());
		}

		vendedor.setEndereco(endereco);
		vendedor.setNome(obj.getNome());
		vendedor.setCpf(obj.getCpf());
		vendedor.setDataCriacao(obj.getDataCriacao());
		vendedor.setEmail(obj.getEmail());
		vendedor.setSenha(obj.getSenha());
		return vendedor;
	}

	private void validaPorCpfEEmail(VendedorDTO objDTO) {
		Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegratyViolationException("CPF já cadastrado no sistema!");
		}

		obj = pessoaRepository.findByEmail(objDTO.getEmail());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegratyViolationException("E-mail já cadastrado no sistema!");
		}
	}

}
