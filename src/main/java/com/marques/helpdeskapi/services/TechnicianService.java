package com.marques.helpdeskapi.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.marques.helpdeskapi.Utils.MessageUtil;
import com.marques.helpdeskapi.domain.Person;
import com.marques.helpdeskapi.domain.Technician;
import com.marques.helpdeskapi.domain.dtos.TechnicianDTO;
import com.marques.helpdeskapi.mapper.TechnicianMapper;
import com.marques.helpdeskapi.repositories.PersonRepository;
import com.marques.helpdeskapi.repositories.TechnicianRepository;
import com.marques.helpdeskapi.services.exceptions.DataIntegrityViolationException;
import com.marques.helpdeskapi.services.exceptions.ObjectNotFoundException;

@Service
public class TechnicianService {

	
	@Autowired
	private TechnicianRepository technicianRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
    private final TechnicianMapper technicianMapper = TechnicianMapper.INSTANCE;
	
	public TechnicianDTO findById(Long id) {
		Technician technician = verifyIfExists(id);
		return technicianMapper.toDTO(technician);
	}
	


	
	public List<TechnicianDTO> findAll() {
		List<Technician> allTechnicians = technicianRepository.findAll();
		return allTechnicians.stream().map(x -> technicianMapper.toDTO(x)).collect(Collectors.toList());
	}


	@Transactional
	public TechnicianDTO create(TechnicianDTO objDTO) {
		objDTO.setPassword(encoder.encode(objDTO.getPassword()));
		Technician technicianToSave = technicianMapper.toModel(objDTO);
		
		verifyCpfAndEmail(objDTO);
		technicianRepository.save(technicianToSave);
		return technicianMapper.toDTO(technicianToSave);
	}


	private void verifyCpfAndEmail(TechnicianDTO objDTO) {
		Optional<Person> obj = personRepository.findByCpf(objDTO.getCpf());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException(MessageUtil.CPF_ALREADY_REGISTERED);
		}
		
		obj = personRepository.findByEmail(objDTO.getEmail());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException(MessageUtil.EMAIL_ALREADY_REGISTERED);
		}
	}


	@Transactional
	public TechnicianDTO update(Long id, TechnicianDTO objDTO) {
		objDTO.setId(id);
		objDTO.setPassword(encoder.encode(objDTO.getPassword()));
		findById(id);
		if(!objDTO.getPassword().equals(objDTO.getPassword()) ) {
			objDTO.setPassword(encoder.encode(objDTO.getPassword()));
		}
		
		verifyCpfAndEmail(objDTO);
		Technician technicianUpdate = technicianMapper.toModel(objDTO);
		technicianRepository.save(technicianUpdate);
		return technicianMapper.toDTO(technicianUpdate);
	}
	
	@Transactional
	public void delete(Long id) {
		Technician obj = verifyIfExists(id);
		if(obj.getIncidents().size() > 0) {
			throw new DataIntegrityViolationException(MessageUtil.TECHNICIAN_INCIDENTS);
		} 
		
		technicianRepository.deleteById(id);
		
	}

	
	public Technician verifyIfExists(Long id) {
        return technicianRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(MessageUtil.OBJECT_NOT_FOUND));
    }






}
