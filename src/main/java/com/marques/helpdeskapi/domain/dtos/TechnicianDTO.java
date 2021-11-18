package com.marques.helpdeskapi.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.marques.helpdeskapi.domain.Technician;
import com.marques.helpdeskapi.domain.enums.Profile;

public class TechnicianDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	protected Long id;
	protected String name;
	protected String cpf;
	protected String email;
	protected String password;
	protected Set<Profile> profiles = new HashSet<>();
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate creation_date = LocalDate.now();

	public TechnicianDTO() {
		super();
	}

	public TechnicianDTO(Technician technician) {
		this.id = technician.getId();
		this.name = technician.getName();
		this.cpf = technician.getCpf();
		this.email = technician.getEmail();
		this.password = technician.getPassword();
		this.profiles = technician.getProfiles();
		this.creation_date = technician.getCreation_date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Profile> getProfiles() {
		return profiles;
	}

	public void addProfile(Profile profile) {
		this.profiles.add(profile);
	}

	public LocalDate getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(LocalDate creation_date) {
		this.creation_date = creation_date;
	}
	
	
	

}
