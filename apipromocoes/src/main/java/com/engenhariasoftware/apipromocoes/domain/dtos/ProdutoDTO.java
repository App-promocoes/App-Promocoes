package com.engenhariasoftware.apipromocoes.domain.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.engenhariasoftware.apipromocoes.domain.Produto;

public class ProdutoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotNull(message = "O campo NOME DO PRODUTO é requerido")
	private String nome;

	@NotNull(message = "O campo VALOR é requerido")
	private Double valor;

	@NotNull(message = "O campo QUANTIDADE é requerido")
	private Integer quantidade;

	@NotNull(message = "O campo OFERTA é requerido")
	private Integer oferta;

	private String nomeOferta;

	public ProdutoDTO() {
		super();
	}

	public ProdutoDTO(Produto obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.valor = obj.getValor();
		this.quantidade = obj.getQuantidade();
		this.oferta = obj.getOferta().getId();
		this.nomeOferta = obj.getOferta().getNome();
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

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getOferta() {
		return oferta;
	}

	public void setOferta(Integer oferta) {
		this.oferta = oferta;
	}

	public String getNomeOferta() {
		return nomeOferta;
	}

	public void setNomeOferta(String nomeOferta) {
		this.nomeOferta = nomeOferta;
	}

}
