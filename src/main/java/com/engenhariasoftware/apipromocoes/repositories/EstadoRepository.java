package com.engenhariasoftware.apipromocoes.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.engenhariasoftware.apipromocoes.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
	Optional<Estado> findByNome(String nome);
}
