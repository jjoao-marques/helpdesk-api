package com.marques.helpdeskapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.marques.helpdeskapi.domain.Incident;
import com.marques.helpdeskapi.domain.dtos.IncidentDTO;


@Mapper
public interface IncidentMapper {
	
	IncidentMapper INSTANCE = Mappers.getMapper(IncidentMapper.class);
	
	
	@Mapping(source = "technician", target = "technician.id")
	@Mapping(source = "client", target = "client.id")
	@Mapping(source = "nomeClient", target = "client.name")
	@Mapping(source = "nomeTechnician", target = "technician.name")
	Incident toModel (IncidentDTO incidentDTO);
	
	
	@Mapping(target = "technician", source = "technician.id")
	@Mapping(target = "client", source = "client.id")
	@Mapping(target = "nomeClient", source = "client.name")
	@Mapping(target = "nomeTechnician", source = "technician.name")
	IncidentDTO toDTO(Incident incident);
	
}
