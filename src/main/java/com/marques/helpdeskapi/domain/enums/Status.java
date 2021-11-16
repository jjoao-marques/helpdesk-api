package com.marques.helpdeskapi.domain.enums;

public enum Status {
	
	OPEN(0, "OPEN"),
	PROGRESS(1, "PROGRESS"),
	CLOSED(2, "CLOSED");
	
	private Integer code;
	private String description;
	
	
	private Status(Integer code, String description) {
		this.code = code;
		this.description = description;
	}


	public Integer getCode() {
		return code;
	}


	public String getDescription() {
		return description;
	}
	
	public static Status toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(Status y : Status.values()) {
			if(cod.equals(y.getCode())) {
				return y;
			}
		}
		
		throw new IllegalArgumentException("Status inválido!");
	}

}
