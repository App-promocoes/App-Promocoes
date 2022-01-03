package com.engenhariasoftware.apipromocoes.domain.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.engenhariasoftware.apipromocoes.domain.Endereco;

public class EnderecoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotNull(message = "O campo LOGRADOURO é requerido")
	private String logradouro;

	@NotNull(message = "O campo NÚMERO é requerido")
	private String numero;

	@NotNull(message = "O campo COMPLEMENTO é requerido")
	private String complemento;

	@NotNull(message = "O campo BAIRRO é requerido")
	private String bairro;

	@NotNull(message = "O campo CEP é requerido")
	private String cep;

	@NotNull(message = "O campo CIDADE é requerido")
	private Integer cidade;

	private String nomeCidade;

	public EnderecoDTO() {
		super();
	}

	public EnderecoDTO(Endereco obj) {
		super();
		this.id = obj.getId();
		this.logradouro = obj.getLogradouro();
		this.numero = obj.getNumero();
		this.complemento = obj.getComplemento();
		this.bairro = obj.getBairro();
		this.cep = obj.getCep();
		this.cidade = obj.getCidade().getId();
		this.nomeCidade = obj.getCidade().getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getCidade() {
		return cidade;
	}

	public void setCidade(Integer cidade) {
		this.cidade = cidade;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

}
