package com.marques.helpdeskapi.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marques.helpdeskapi.Utils.MessageUtil;
import com.marques.helpdeskapi.domain.Client;
import com.marques.helpdeskapi.domain.Person;
import com.marques.helpdeskapi.domain.dtos.ClientDTO;
import com.marques.helpdeskapi.mapper.ClientMapper;
import com.marques.helpdeskapi.repositories.ClientRepository;
import com.marques.helpdeskapi.repositories.PersonRepository;
import com.marques.helpdeskapi.services.exceptions.DataIntegrityViolationException;
import com.marques.helpdeskapi.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {

	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
    private final ClientMapper clientMapper = ClientMapper.INSTANCE;
	
	public ClientDTO findById(Long id) {
		Client Client = verifyIfExists(id);
		return clientMapper.toDTO(Client);
	}
	


	
	public List<ClientDTO> findAll() {
		List<Client> allClients = clientRepository.findAll();
		return allClients.stream().map(x -> clientMapper.toDTO(x)).collect(Collectors.toList());
	}


	@Transactional
	public ClientDTO create(ClientDTO objDTO) {
		Client ClientToSave = clientMapper.toModel(objDTO);
		verifyCpfAndEmail(objDTO);
		clientRepository.save(ClientToSave);
		return clientMapper.toDTO(ClientToSave);
	}


	private void verifyCpfAndEmail(ClientDTO objDTO) {
		Optional<Person> obj = personRepository.findByCpf(objDTO.getCpf());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException(MessageUtil.CPF_ALREADY_REGISTERED);
		}
		
		obj = personRepository.findByEmail(objDTO.getEmail());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException(MessageUtil.EMAIL_ALREADY_REGISTERED);
		}
	}


	@Transactional
	public ClientDTO update(Long id, ClientDTO objDTO) {
		findById(id);
		verifyCpfAndEmail(objDTO);
		Client clientUpdate = clientMapper.toModel(objDTO);
		clientRepository.save(clientUpdate);
		return clientMapper.toDTO(clientUpdate);
	}
	
	@Transactional
	public void delete(Long id) {
		Client obj = verifyIfExists(id);
		if(obj.getIncidents().size() > 0) {
			throw new DataIntegrityViolationException(MessageUtil.CLIENT_INCIDENTS);
		} 
		
		clientRepository.deleteById(id);
		
	}

	
	public Client verifyIfExists(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(MessageUtil.OBJECT_NOT_FOUND));
    }






}
