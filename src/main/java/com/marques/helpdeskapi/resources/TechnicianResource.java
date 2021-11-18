package com.marques.helpdeskapi.resources;

import java.net.URI;
import java.util.List;

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

import com.marques.helpdeskapi.domain.dtos.TechnicianDTO;
import com.marques.helpdeskapi.services.TechnicianService;

@RestController
@RequestMapping(value = "/technicians")
public class TechnicianResource {
	
	@Autowired
	private TechnicianService technicianService;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TechnicianDTO> findById(@PathVariable Long id) {
		TechnicianDTO obj = technicianService.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	@GetMapping
	public ResponseEntity<List<TechnicianDTO>> findAll() {
		List<TechnicianDTO> list = technicianService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<TechnicianDTO> createTechnician(@Valid @RequestBody TechnicianDTO objDTO) {
		TechnicianDTO newObj = technicianService.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<TechnicianDTO> update(@PathVariable Long id, @Valid @RequestBody TechnicianDTO objDTO) {
		TechnicianDTO oldObj = technicianService.update(id, objDTO);
		return ResponseEntity.ok().body(oldObj); 
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<TechnicianDTO> delete(@Valid @PathVariable Long id) {
		technicianService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
