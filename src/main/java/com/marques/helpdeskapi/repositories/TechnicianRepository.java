package com.marques.helpdeskapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marques.helpdeskapi.domain.Technician;

public interface TechnicianRepository  extends JpaRepository<Technician, Long>{

}
