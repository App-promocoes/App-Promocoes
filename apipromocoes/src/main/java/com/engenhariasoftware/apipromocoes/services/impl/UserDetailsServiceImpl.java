package com.engenhariasoftware.apipromocoes.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.engenhariasoftware.apipromocoes.domain.Pessoa;
import com.engenhariasoftware.apipromocoes.repositories.PessoaRepository;
import com.engenhariasoftware.apipromocoes.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Pessoa> user = pessoaRepository.findByEmail(email);
		if(user.isPresent()) {
			return new UserSS(
					user.get().getId(), 
					user.get().getEmail(), 
					user.get().getSenha(), 
					user.get().getPerfis());
		}
		throw new UsernameNotFoundException(email);
	}

}
