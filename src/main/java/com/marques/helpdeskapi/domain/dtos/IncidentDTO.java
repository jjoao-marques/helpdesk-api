package com.marques.helpdeskapi.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.marques.helpdeskapi.Utils.MessageUtil;
import com.marques.helpdeskapi.domain.enums.Priority;
import com.marques.helpdeskapi.domain.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class IncidentDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	

	private Long id;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate open_date = LocalDate.now();

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate closed_date;
	
	@NotNull(message = MessageUtil.FIELD_PRIORITY_IS_REQUIRED)
	private Priority priority;
	
	@NotNull(message = MessageUtil.FIELD_STATUS_IS_REQUIRED)
	private Status status;
	
	@NotNull(message = MessageUtil.FIELD_TITLE_IS_REQUIRED)
	private String title;
	
	@NotNull(message = MessageUtil.FIELD_DESCRIPTION_IS_REQUIRED)
	private String description;
	
	@NotNull(message = MessageUtil.FIELD_TECHNICIAN_IS_REQUIRED)
	private Long technician;
	
	@NotNull(message = MessageUtil.FIELD_CLIENT_IS_REQUIRED)
	private Long client;
	
	private String nomeTechnician;
	private String nomeClient;
	


	
	
	

	
	
	
	

}
