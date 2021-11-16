package com.marques.helpdeskapi.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.marques.helpdeskapi.domain.enums.Profile;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
public abstract class Person {
	
	@EqualsAndHashCode.Include
	protected Long id;
	
	protected String name;
	
	@EqualsAndHashCode.Include
	protected String cpf;
	
	protected String email;
	protected String password;
	protected Set<Integer> profiles = new HashSet<>();
	protected LocalDate creation_date = LocalDate.now();
	
	
	
	public Person() {
		super();
		addProfile(Profile.CLIENT);
	}
	
	public Person(Long id, String name, String cpf, String email, String password) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.password = password;
		addProfile(Profile.CLIENT);
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
		return profiles.stream().map(x -> Profile.toEnum(x)).collect(Collectors.toSet());
	}



	public void addProfile(Profile profile) {
		this.profiles.add(profile.getCode());
	}



	public LocalDate getCreation_date() {
		return creation_date;
	}



	public void setCreation_date(LocalDate creation_date) {
		this.creation_date = creation_date;
	}

	
	
}
