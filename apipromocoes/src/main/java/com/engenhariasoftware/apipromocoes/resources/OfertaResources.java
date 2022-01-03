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

import com.engenhariasoftware.apipromocoes.domain.Oferta;
import com.engenhariasoftware.apipromocoes.domain.dtos.OfertaDTO;
import com.engenhariasoftware.apipromocoes.services.OfertaService;

@RestController
@RequestMapping(value = "/ofertas")
public class OfertaResources {

	private static final String ID = "/{id}";
	
	@Autowired
	private OfertaService service;
	
	@GetMapping(value = ID)
	public ResponseEntity<OfertaDTO> findById(@PathVariable Integer id) {
		Oferta obj = service.findById(id);
		return ResponseEntity.ok().body(new OfertaDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<OfertaDTO>> findAll() {
		List<Oferta> list = service.findAll();
		List<OfertaDTO> listDTO = list.stream().map(obj -> new OfertaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<OfertaDTO> create(@RequestBody OfertaDTO objDTO) {
		Oferta obj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path(ID).buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = ID)
	public ResponseEntity<OfertaDTO> update(@PathVariable Integer id, @RequestBody OfertaDTO objDTO) {
		Oferta newObj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new OfertaDTO(newObj));	
	}
	
	@DeleteMapping(value = ID)
	public ResponseEntity<OfertaDTO> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
