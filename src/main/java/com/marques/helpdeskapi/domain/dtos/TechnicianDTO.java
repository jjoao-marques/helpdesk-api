package com.marques.helpdeskapi.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.marques.helpdeskapi.Utils.MessageUtil;
import com.marques.helpdeskapi.domain.enums.Profile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TechnicianDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	protected Long id;
	
	@NotNull(message = MessageUtil.FIELD_NAME_IS_REQUIRED)
	protected String name;
	
	@NotNull(message = MessageUtil.FIELD_CPF_IS_REQUIRED)
	protected String cpf;
	
	@NotNull(message = MessageUtil.FIELD_EMAIL_IS_REQUIRED)
	protected String email;
	
	@NotNull(message = MessageUtil.FIELD_PASSWORD_IS_REQUIRED)
	protected String password;
	
	
	protected Set<Profile> profiles = new HashSet<>();
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate creation_date = LocalDate.now();

	public TechnicianDTO() {
		super();
		addProfile(Profile.CLIENT);
	}
	
	public void addProfile(Profile profile) {
		this.profiles.add(profile);
	}



	
	

}
