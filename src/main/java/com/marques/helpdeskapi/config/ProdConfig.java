package com.marques.helpdeskapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.marques.helpdeskapi.services.DBService;

@Configuration
@Profile("prod")
public class ProdConfig {
	
	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String value;
	
	
	@Bean
	public boolean startDB() {
		if(value.equals("create")) {			
			this.dbService.startDB();
		}
		return false;
	}
}
