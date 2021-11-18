package com.marques.helpdeskapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.marques.helpdeskapi.domain.Client;
import com.marques.helpdeskapi.domain.dtos.ClientDTO;

@Mapper
public interface ClientMapper {
	
	ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);
	
	@Mapping(target = "incidents", ignore = true)
	 Client toModel (ClientDTO clientDTO);
	
	 ClientDTO toDTO(Client client);
	
}
