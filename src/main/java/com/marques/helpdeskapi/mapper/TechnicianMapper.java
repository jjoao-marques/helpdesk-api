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
	Technician toModel (TechnicianDTO technicianDTO);
	
	TechnicianDTO toDTO(Technician technician);
	
}
