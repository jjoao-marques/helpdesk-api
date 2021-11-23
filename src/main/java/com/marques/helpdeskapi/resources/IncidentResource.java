package com.marques.helpdeskapi.resources;

import java.net.URI;
import java.util.List;

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

import com.marques.helpdeskapi.domain.dtos.IncidentDTO;
import com.marques.helpdeskapi.services.IncidentService;

@RestController
@RequestMapping(value = "/incidents")
public class IncidentResource {
	
	@Autowired
	private IncidentService incidentService;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<IncidentDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok(incidentService.findById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<IncidentDTO>> findAll() {
		return ResponseEntity.ok().body(incidentService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<IncidentDTO> create(@Valid @RequestBody IncidentDTO obj) {
		IncidentDTO newObj = incidentService.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@PreAuthorize("hasAuthority('ADMIN', 'TECHNICIAN')")
	@PutMapping(value = "/{id}")
	public ResponseEntity<IncidentDTO> update(@Valid @RequestBody IncidentDTO objDTO, @PathVariable Long id) {
		return ResponseEntity.ok().body(incidentService.update(id, objDTO));
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		incidentService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
