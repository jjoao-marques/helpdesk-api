package com.marques.helpdeskapi.domain;

import java.util.ArrayList;
import java.util.List;


public class Client extends Person{
	
	private List<Incident> incidents = new ArrayList<>();

	public Client() {
		super();
	}

	public Client(Long id, String name, String cpf, String email, String password) {
		super(id, name, cpf, email, password);
	}

	public List<Incident> getIncidents() {
		return incidents;
	}

	public void setIncidents(List<Incident> incidents) {
		this.incidents = incidents;
	}
	
	

}
