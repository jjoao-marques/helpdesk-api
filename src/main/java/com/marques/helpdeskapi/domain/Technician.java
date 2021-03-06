package com.marques.helpdeskapi.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.marques.helpdeskapi.domain.enums.Profile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tb_technician")
public class Technician extends Person{
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@OneToMany(mappedBy = "technician")
	private List<Incident> incidents = new ArrayList<>();

	public Technician() {
		super();
		addProfile(Profile.CLIENT);
	}

	public Technician(Long id, String name, String cpf, String email, String password) {
		super(id, name, cpf, email, password);
		addProfile(Profile.CLIENT);
	}


	
	
	
	

}
