package com.marques.helpdeskapi.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.marques.helpdeskapi.domain.enums.Profile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ClientDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	protected Long id;
	protected String name;
	protected String cpf;
	protected String email;
	protected String password;
	protected Set<Profile> profiles = new HashSet<>();
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate creation_date = LocalDate.now();

	public ClientDTO() {
		super();
		addProfile(Profile.CLIENT);
	}

	
	public void addProfile(Profile profile) {
		this.profiles.add(profile);
	}

	
	
	

}
