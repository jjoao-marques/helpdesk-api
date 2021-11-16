package com.marques.helpdeskapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marques.helpdeskapi.domain.Person;

public interface PersonRepository  extends JpaRepository<Person, Long>{

}
