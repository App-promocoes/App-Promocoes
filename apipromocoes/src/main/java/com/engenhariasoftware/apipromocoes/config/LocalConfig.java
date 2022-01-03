package com.engenhariasoftware.apipromocoes.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.engenhariasoftware.apipromocoes.services.DBService;

@Configuration
@Profile("local")
public class LocalConfig {

	@Autowired
	private DBService dbService;

	@Bean
	public void instanciaDB() {
		this.dbService.instanciaDB();
	}

}
