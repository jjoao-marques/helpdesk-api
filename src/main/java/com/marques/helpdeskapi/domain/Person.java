package com.marques.helpdeskapi.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.marques.helpdeskapi.domain.enums.Profile;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity(name = "tb_person")
public abstract class Person implements Serializable{
	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	protected String name;
	
	@EqualsAndHashCode.Include
	@Column(unique = true)
	protected String cpf;
	
	@Column(unique = true)
	protected String email;
	protected String password;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "PROFILES")
	@Enumerated(EnumType.STRING)
	protected Set<Profile> profiles = new HashSet<>();
	
	@JsonFormat(pattern = "dd/MM/yyyy")
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

	
	public void addProfile(Profile profile) {
		this.profiles.add(profile);
	}

	
	
}
