package com.marques.helpdeskapi.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
