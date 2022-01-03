package com.engenhariasoftware.apipromocoes.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.engenhariasoftware.apipromocoes.domain.Produto;
import com.engenhariasoftware.apipromocoes.domain.dtos.ProdutoDTO;
import com.engenhariasoftware.apipromocoes.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResources {

	private static final String ID = "/{id}";

	@Autowired
	private ProdutoService service;

	@GetMapping(value = ID)
	public ResponseEntity<ProdutoDTO> findById(@PathVariable Integer id) {
		Produto obj = service.findById(id);
		return ResponseEntity.ok().body(new ProdutoDTO(obj));
	}

	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> findAll() {
		List<Produto> list = service.findAll();
		List<ProdutoDTO> listDTO = list.stream().map(obj -> new ProdutoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<ProdutoDTO> create(@Valid @RequestBody ProdutoDTO objDTO) {
		Produto obj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path(ID).buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = ID)
	public ResponseEntity<ProdutoDTO> update(@PathVariable Integer id, @Valid @RequestBody ProdutoDTO objDTO) {
		Produto newObj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new ProdutoDTO(newObj));
	}

	@DeleteMapping(value = ID)
	public ResponseEntity<ProdutoDTO> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
