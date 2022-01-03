package com.engenhariasoftware.apipromocoes.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.engenhariasoftware.apipromocoes.domain.Categoria;
import com.engenhariasoftware.apipromocoes.domain.Cidade;
import com.engenhariasoftware.apipromocoes.domain.Cliente;
import com.engenhariasoftware.apipromocoes.domain.Endereco;
import com.engenhariasoftware.apipromocoes.domain.Estado;
import com.engenhariasoftware.apipromocoes.domain.Loja;
import com.engenhariasoftware.apipromocoes.domain.Oferta;
import com.engenhariasoftware.apipromocoes.domain.Produto;
import com.engenhariasoftware.apipromocoes.domain.Vendedor;
import com.engenhariasoftware.apipromocoes.domain.enuns.Perfil;
import com.engenhariasoftware.apipromocoes.repositories.CategoriaRepository;
import com.engenhariasoftware.apipromocoes.repositories.CidadeRepository;
import com.engenhariasoftware.apipromocoes.repositories.ClienteRepository;
import com.engenhariasoftware.apipromocoes.repositories.EnderecoRepository;
import com.engenhariasoftware.apipromocoes.repositories.EstadoRepository;
import com.engenhariasoftware.apipromocoes.repositories.LojaRepository;
import com.engenhariasoftware.apipromocoes.repositories.OfertaRepository;
import com.engenhariasoftware.apipromocoes.repositories.ProdutoRepository;
import com.engenhariasoftware.apipromocoes.repositories.VendedorRepository;

@Service
public class DBService {

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private EstadoRepository repository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private OfertaRepository ofertaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private LojaRepository lojaRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private VendedorRepository vendedorRepository;

	public void instanciaDB() {

		Estado e1 = new Estado(null, "Pernambuco");
		Estado e2 = new Estado(null, "Alagoas");

		repository.saveAll(List.of(e1, e2));

		Cidade c1 = new Cidade(null, "Garanhuns", e1);
		Cidade c2 = new Cidade(null, "Palmeiras dos Indios", e2);
		cidadeRepository.saveAll(List.of(c1, c2));

		Endereco end1 = new Endereco(null, "Rua São Jorge", "23", "Casa", "Magano", "55294-560", c1);
		Endereco end2 = new Endereco(null, "Travessa Baixa Fria", "67", "Ap1", "Palmeira de Fora", "57608-380", c2);
		enderecoRepository.saveAll(List.of(end1, end2));

		Categoria cat1 = new Categoria(null, "Eletronico");
		Categoria cat2 = new Categoria(null, "Bebidas");
		categoriaRepository.saveAll(List.of(cat1, cat2));

		Oferta of1 = new Oferta(null, "Fire TV", 239.00);
		Oferta of2 = new Oferta(null, "Caixas Red Bull", 159.00);
		ofertaRepository.saveAll(List.of(of1, of2));

		Produto p1 = new Produto(null, "Fire TV", 289.00, 10, of1);
		Produto p2 = new Produto(null, "Caixas Red Bull", 189.00, 100, of2);
		produtoRepository.saveAll(List.of(p1, p2));

		Cliente cli1 = new Cliente(null, "João", "709.846.000-19", "joa@gamil.com", encoder.encode("123"), end2);
		cli1.addPerfil(Perfil.CLIENTE);
		clienteRepository.saveAll(Arrays.asList(cli1));

		Vendedor v1 = new Vendedor(null, "Maria", "842.747.810-03", "maria@gmail.com", encoder.encode("1234"), end2);
		v1.addPerfil(Perfil.ADMIN);
		vendedorRepository.saveAll(Arrays.asList(v1));

		Loja l1 = new Loja(null, "Insinuante", "34.716.839/0001-42", "8799999999", end2, of2, cli1);
		Loja l2 = new Loja(null, "Americanas", "54.459.131/0001-60", "98868686", end2, of2, cli1);
		lojaRepository.saveAll(List.of(l1, l2));

		l1.getProdutos().addAll(Arrays.asList(p1));
		l2.getProdutos().addAll(Arrays.asList(p2));

		p1.getLojas().addAll(Arrays.asList(l1));
		p2.getLojas().addAll(Arrays.asList(l2));

	}

}
