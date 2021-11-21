package com.marques.helpdeskapi.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marques.helpdeskapi.Utils.MessageUtil;
import com.marques.helpdeskapi.domain.Incident;
import com.marques.helpdeskapi.domain.dtos.IncidentDTO;
import com.marques.helpdeskapi.domain.enums.Status;
import com.marques.helpdeskapi.mapper.IncidentMapper;
import com.marques.helpdeskapi.repositories.IncidentRepository;
import com.marques.helpdeskapi.services.exceptions.ObjectNotFoundException;

@Service
public class IncidentService {
	
	@Autowired
	private IncidentRepository incidentRepository;
	
	@Autowired
	private TechnicianService technicianService;
	
	@Autowired
	private ClientService clientService;
	
	
	private static  IncidentMapper incidentMapper = IncidentMapper.INSTANCE;
	
	@Transactional(readOnly = true)
	public IncidentDTO findById(Long id) {
		return incidentRepository.findById(id).map(x -> incidentMapper.toDTO(x))
				.orElseThrow(() -> new ObjectNotFoundException(MessageUtil.OBJECT_NOT_FOUND));
	}


	@Transactional(readOnly = true)
	public List<IncidentDTO> findAll() {
		List<Incident> list = incidentRepository.findAll();
		return list.stream().map(x -> incidentMapper.toDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public IncidentDTO create(IncidentDTO obj) {
		technicianService.findById(obj.getTechnician());
		clientService.findById(obj.getClient());
		
		Incident incidentToSave = incidentMapper.toModel(obj);
		incidentRepository.save(incidentToSave);
		return incidentMapper.toDTO(incidentToSave);
	}
	
	
	@Transactional
	public IncidentDTO update(Long id, IncidentDTO objDTO) {
		objDTO.setId(id);
		findById(id);
		
		technicianService.findById(objDTO.getTechnician());
		clientService.findById(objDTO.getClient());

		
		
		Incident incidentUpdate = incidentMapper.toModel(objDTO);
		
		if(objDTO.getStatus().equals(Status.CLOSED)) {
			incidentUpdate.setClosed_date(LocalDate.now());
		}
		incidentRepository.save(incidentUpdate);
		return incidentMapper.toDTO(incidentUpdate);
	}
	
	
	@Transactional
	public void delete(Long id) {
		findById(id);
		incidentRepository.deleteById(id);
	}


}
