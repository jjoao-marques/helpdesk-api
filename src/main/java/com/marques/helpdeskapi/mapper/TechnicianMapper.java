package com.marques.helpdeskapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.marques.helpdeskapi.domain.Technician;
import com.marques.helpdeskapi.domain.dtos.TechnicianDTO;


@Mapper
public interface TechnicianMapper {
	
	TechnicianMapper INSTANCE = Mappers.getMapper(TechnicianMapper.class);
	
	@Mapping(target = "incidents", ignore = true)
	@Mapping(target = "creation_date", source = "creation_date")
	@Mapping(target = "profiles", source = "profiles")
	Technician toModel (TechnicianDTO technicianDTO);
	
	@Mapping(source = "creation_date", target = "creation_date")
	@Mapping(source = "profiles", target = "profiles")
	TechnicianDTO toDTO(Technician technician);
	
}
