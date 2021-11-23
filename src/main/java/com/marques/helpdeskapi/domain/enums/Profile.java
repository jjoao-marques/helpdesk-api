package com.marques.helpdeskapi.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Profile {
	
	ADMIN("ADMIN"), 
	CLIENT("CLIENT"),
	TECHNICIAN("TECHNICIAN");
	
	private String description;
	
}
