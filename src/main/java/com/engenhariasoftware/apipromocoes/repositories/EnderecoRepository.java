package com.engenhariasoftware.apipromocoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.engenhariasoftware.apipromocoes.domain.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
