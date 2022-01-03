package com.engenhariasoftware.apipromocoes.domain;

import java.io.Serializable;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.engenhariasoftware.apipromocoes.domain.dtos.VendedorDTO;
import com.engenhariasoftware.apipromocoes.domain.enuns.Perfil;

@Entity
public class Vendedor extends Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "loja")
	private Loja loja;

	public Vendedor() {
		super();
		addPerfil(Perfil.CLIENTE);
	}

	public Vendedor(Integer id, String nome, String cpf, String email, String senha, Endereco endereco) {
		super(id, nome, cpf, email, senha, endereco);
	}

	public Vendedor(VendedorDTO obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = obj.getDataCriacao();
		addPerfil(Perfil.CLIENTE);
	}
	
	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

}
