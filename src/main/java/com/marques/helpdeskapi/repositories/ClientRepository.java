package com.marques.helpdeskapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marques.helpdeskapi.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
