package com.engenhariasoftware.apipromocoes.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.engenhariasoftware.apipromocoes.domain.Vendedor;
import com.engenhariasoftware.apipromocoes.domain.dtos.VendedorDTO;
import com.engenhariasoftware.apipromocoes.services.VendedorService;

@RestController
@RequestMapping(value = "/vendedores")
public class VendedorResources {

	private static final String ID = "/{id}";
	
	@Autowired
	private VendedorService service;
	
	@GetMapping(value = ID)
	public ResponseEntity<VendedorDTO> findById(@PathVariable Integer id) {
		Vendedor obj = service.findById(id);
		return ResponseEntity.ok().body(new VendedorDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<VendedorDTO>> findAll() {
		List<Vendedor> list = service.findAll();
		List<VendedorDTO> listDTO = list.stream().map(obj -> new VendedorDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping
	public ResponseEntity<VendedorDTO> create(@RequestBody VendedorDTO objDTO) {
		Vendedor obj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(null).build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PutMapping(value = ID)
	public ResponseEntity<VendedorDTO> update(@PathVariable Integer id, @Valid @RequestBody VendedorDTO objDTO) {
		Vendedor newObj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new VendedorDTO(newObj));
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping(value = ID)
	public ResponseEntity<VendedorDTO> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
