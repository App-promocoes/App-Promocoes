package com.engenhariasoftware.apipromocoes.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
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

import com.engenhariasoftware.apipromocoes.domain.Estado;
import com.engenhariasoftware.apipromocoes.domain.dtos.EstadoDTO;
import com.engenhariasoftware.apipromocoes.services.EstadoService;

@RestController
@RequestMapping(value = "/estados")
public class EstadoResources {

	private static final String ID = "/{id}";

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private EstadoService service;
	
	@GetMapping(value = ID)
	public ResponseEntity<EstadoDTO> findById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(mapper.map(service.findById(id), EstadoDTO.class));
	}
	
	@GetMapping
	public ResponseEntity<List<EstadoDTO>> findAll() {
		return ResponseEntity.ok()
				.body(service.findAll()
						.stream().map(x -> mapper.map(x, EstadoDTO.class)).collect(Collectors.toList()));
	}

	@PostMapping
	public ResponseEntity<EstadoDTO> create(@RequestBody EstadoDTO obj) {
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path(ID).buildAndExpand(service.create(obj).getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = ID)
	public ResponseEntity<EstadoDTO> update(@PathVariable Integer id, @RequestBody EstadoDTO obj) {
		obj.setId(id);
		Estado newObj = service.update(obj);
		return ResponseEntity.ok().body(mapper.map(newObj, EstadoDTO.class));	
	}
	
	@DeleteMapping(value = ID)
	public ResponseEntity<EstadoDTO> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
