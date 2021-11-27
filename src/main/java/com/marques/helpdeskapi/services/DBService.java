package com.marques.helpdeskapi.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.marques.helpdeskapi.domain.Technician;
import com.marques.helpdeskapi.domain.enums.Profile;
import com.marques.helpdeskapi.repositories.TechnicianRepository;

@Service
public class DBService {
	
	@Autowired
	private TechnicianRepository technicianRepository;
	
//	@Autowired
//	private ClientRepository clientRepository;
//	
//	@Autowired
//	private IncidentRepository incidentRepository;
	
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	public void startDB() {
		
		
		Technician tec1 = new Technician(null, "João Marques", "00253323096", "joaomarques.jm991@gmail.com", encoder.encode("12345678"));
		tec1.addProfile(Profile.ADMIN);
		
//		Client cli1 = new Client(null, "Taiane Santos", "66003493011", "taiane@mail.com", encoder.encode("456"));
//		
//		Incident incident1 = new Incident(null, Priority.MEDIUM, Status.PROGRESS, "Chamado 1", "Primeiro chamado", tec1, cli1);
		
		
		technicianRepository.saveAll(Arrays.asList(tec1));
//		clientRepository.saveAll(Arrays.asList(cli1));
//		incidentRepository.saveAll(Arrays.asList(incident1));
	}
	
}
