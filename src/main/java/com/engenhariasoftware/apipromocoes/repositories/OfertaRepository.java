package com.engenhariasoftware.apipromocoes.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.engenhariasoftware.apipromocoes.domain.Oferta;

public interface OfertaRepository extends JpaRepository<Oferta, Integer> {

	Optional<Oferta> findByNome(String nome);

}
