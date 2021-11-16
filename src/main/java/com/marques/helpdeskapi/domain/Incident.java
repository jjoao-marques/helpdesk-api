package com.marques.helpdeskapi.domain;

import java.time.LocalDate;

import com.marques.helpdeskapi.domain.enums.Priority;
import com.marques.helpdeskapi.domain.enums.Status;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Incident {
	
	@EqualsAndHashCode.Include
	private Long id;
	private LocalDate open_date = LocalDate.now();
	private LocalDate closed_date;
	private Priority priority;
	private Status status;
	private String title;
	private String description;
	
	private Technician technician;
	private Client client;
	
	public Incident() {
		super();
	}

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getOpen_date() {
		return open_date;
	}

	public void setOpen_date(LocalDate open_date) {
		this.open_date = open_date;
	}

	public LocalDate getClosed_date() {
		return closed_date;
	}

	public void setClosed_date(LocalDate closed_date) {
		this.closed_date = closed_date;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Technician getTechnician() {
		return technician;
	}

	public void setTechnician(Technician technician) {
		this.technician = technician;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
	
	

}
