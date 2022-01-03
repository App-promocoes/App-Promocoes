package com.engenhariasoftware.apipromocoes.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.engenhariasoftware.apipromocoes.domain.Loja;

public interface LojaRepository extends JpaRepository<Loja, Integer> {

	Optional<Loja> findByCnpj(String cnpj);
	
}
