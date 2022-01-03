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

import com.engenhariasoftware.apipromocoes.domain.Cidade;
import com.engenhariasoftware.apipromocoes.domain.dtos.CidadeDTO;
import com.engenhariasoftware.apipromocoes.services.CidadeService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeResources {

	private static final String ID = "/{id}";

	@Autowired
	private CidadeService service;

	@GetMapping(value = ID)
	public ResponseEntity<CidadeDTO> findById(@PathVariable Integer id) {
		Cidade obj = service.findById(id);
		return ResponseEntity.ok().body(new CidadeDTO(obj));
	}

	@GetMapping
	public ResponseEntity<List<CidadeDTO>> findAll() {
		List<Cidade> list = service.findAll();
		List<CidadeDTO> listDTO = list.stream().map(obj -> new CidadeDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<CidadeDTO> create(@Valid @RequestBody CidadeDTO objDTO) {
		Cidade obj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.
				fromCurrentRequest().path(ID).buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = ID)
	public ResponseEntity<CidadeDTO> update(@PathVariable Integer id, @Valid @RequestBody CidadeDTO objDTO) {
		Cidade newObj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new CidadeDTO(newObj));
	}
	
	@DeleteMapping(value = ID)
	public ResponseEntity<CidadeDTO> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
