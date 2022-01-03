package com.engenhariasoftware.apipromocoes.domain.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.engenhariasoftware.apipromocoes.domain.Categoria;

public class CategoriaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotNull(message = "O campo NOME DA CATEGORIA é requerido")
	private String nome;

	public CategoriaDTO() {
		super();
	}

	public CategoriaDTO(Categoria obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
