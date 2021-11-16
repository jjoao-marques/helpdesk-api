package com.marques.helpdeskapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marques.helpdeskapi.domain.Incident;

public interface IncidentRepository extends JpaRepository<Incident, Long>{

}
