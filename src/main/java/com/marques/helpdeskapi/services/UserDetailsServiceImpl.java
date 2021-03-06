package com.marques.helpdeskapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.marques.helpdeskapi.domain.Person;
import com.marques.helpdeskapi.repositories.PersonRepository;
import com.marques.helpdeskapi.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Person> user = personRepository.findByEmail(email);
		if(user.isPresent()) {
			return new UserSS(user.get().getId(),user.get().getName(), user.get().getEmail(), user.get().getPassword(), user.get().getProfiles());
		}
		throw new UsernameNotFoundException(email);
	}

}
