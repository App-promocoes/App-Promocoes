package com.engenhariasoftware.apipromocoes.domain.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.engenhariasoftware.apipromocoes.domain.Cidade;

public class CidadeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotNull(message = "O campo NOME CIDADE é requerido")
	private String nome;

	@NotNull(message = "O campo ESTADO é requerido")
	private Integer estado;

	private String nomeEstado;

	public CidadeDTO() {
		super();
	}

	public CidadeDTO(Cidade obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.estado = obj.getEstado().getId();
		this.nomeEstado = obj.getEstado().getNome();
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

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getNomeEstado() {
		return nomeEstado;
	}

	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}

}
