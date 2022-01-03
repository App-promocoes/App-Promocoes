package com.engenhariasoftware.apipromocoes.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.engenhariasoftware.apipromocoes.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

	Optional<Categoria> findByNome(String nome);

}
