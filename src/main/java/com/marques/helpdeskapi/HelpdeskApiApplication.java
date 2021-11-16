package com.marques.helpdeskapi;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marques.helpdeskapi.domain.Client;
import com.marques.helpdeskapi.domain.Incident;
import com.marques.helpdeskapi.domain.Technician;
import com.marques.helpdeskapi.domain.enums.Priority;
import com.marques.helpdeskapi.domain.enums.Profile;
import com.marques.helpdeskapi.domain.enums.Status;
import com.marques.helpdeskapi.repositories.ClientRepository;
import com.marques.helpdeskapi.repositories.IncidentRepository;
import com.marques.helpdeskapi.repositories.TechnicianRepository;

@SpringBootApplication
public class HelpdeskApiApplication implements CommandLineRunner {
	
	@Autowired
	private TechnicianRepository technicianRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private IncidentRepository incidentRepository;

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Technician tec1 = new Technician(null, "João Marques", "00253323096", "joao@mail.com", "123");
		tec1.addProfile(Profile.ADMIN);
		
		Client cli1 = new Client(null, "Taiane Santos", "66003493011", "taiane@mail.com", "456");
		
		Incident incident1 = new Incident(null, Priority.MEDIUM, Status.PROGRESS, "Chamado 1", "Primeiro chamado", tec1, cli1);
		
		
		technicianRepository.saveAll(Arrays.asList(tec1));
		clientRepository.saveAll(Arrays.asList(cli1));
		incidentRepository.saveAll(Arrays.asList(incident1));
		
		
		
	}

}
