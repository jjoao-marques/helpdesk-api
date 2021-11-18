package com.marques.helpdeskapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marques.helpdeskapi.domain.Technician;

@Repository
public interface TechnicianRepository  extends JpaRepository<Technician, Long>{

}
