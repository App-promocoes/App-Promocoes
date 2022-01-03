package com.engenhariasoftware.apipromocoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.engenhariasoftware.apipromocoes.domain.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {

}
