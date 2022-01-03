package com.engenhariasoftware.apipromocoes.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

import com.engenhariasoftware.apipromocoes.domain.Loja;
import com.engenhariasoftware.apipromocoes.domain.dtos.LojaDTO;
import com.engenhariasoftware.apipromocoes.services.LojaService;

@RestController
@RequestMapping(value = "/lojas")
public class LojaResources {

	private static final String ID = "/{id}";
	
	@Autowired
	private LojaService service;
	
	@GetMapping(value = ID)
	public ResponseEntity<LojaDTO> findById(@PathVariable Integer id) {
		Loja obj = service.findById(id);
		return ResponseEntity.ok().body(new LojaDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<LojaDTO>> findAll() {
		List<Loja> list = service.findAll();
		List<LojaDTO> listDTO = list.stream().map(obj -> new LojaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<LojaDTO> create(@RequestBody LojaDTO objDTO) {
		Loja obj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path(ID).buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = ID)
	public ResponseEntity<LojaDTO> update(@PathVariable Integer id, @RequestBody LojaDTO objDTO) {
		Loja newObj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new LojaDTO(newObj));	
	}
	
	@DeleteMapping(value = ID)
	public ResponseEntity<LojaDTO> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
