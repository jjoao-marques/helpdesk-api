package com.marques.helpdeskapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marques.helpdeskapi.Utils.MessageUtil;
import com.marques.helpdeskapi.domain.Technician;
import com.marques.helpdeskapi.domain.dtos.TechnicianDTO;
import com.marques.helpdeskapi.mapper.TechnicianMapper;
import com.marques.helpdeskapi.repositories.TechnicianRepository;
import com.marques.helpdeskapi.services.exceptions.ObjectNotFoundException;

@Service
public class TechnicianService {

	
	@Autowired
	private TechnicianRepository technicianRepository;
	
    private final TechnicianMapper technicianMapper = TechnicianMapper.INSTANCE;
	
	public TechnicianDTO findById(Long id) {
		Technician technician = verifyIfExists(id);
		return technicianMapper.toDTO(technician);
	}
	
	
	public Technician verifyIfExists(Long id) {
        return technicianRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(MessageUtil.OBJECT_NOT_FOUND));
    }

}
