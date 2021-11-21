package com.marques.helpdeskapi.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.marques.helpdeskapi.domain.enums.Priority;
import com.marques.helpdeskapi.domain.enums.Status;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "tb_incidents")
public class Incident implements Serializable{
	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate open_date = LocalDate.now();
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate closed_date;
	private Priority priority;
	private Status status;
	private String title;
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "technician_id")
	private Technician technician;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	

	public Incident(Long id, Priority priority, Status status, String title, String description, Technician technician,
			Client client) {
		super();
		this.id = id;
		this.priority = priority;
		this.status = status;
		this.title = title;
		this.description = description;
		this.technician = technician;
		this.client = client;
	}
	
	
//	public void setTechnicianId(Long id) {
//		this.id = id;
//	}

	

	
	
	
	

}
