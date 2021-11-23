package com.marques.helpdeskapi.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
    private final ClientMapper clientMapper = ClientMapper.INSTANCE;
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Client Client = verifyIfExists(id);
		return clientMapper.toDTO(Client);
	}
	


	
	@Transactional(readOnly = true)
	public List<ClientDTO> findAll() {
		List<Client> allClients = clientRepository.findAll();
		return allClients.stream().map(x -> clientMapper.toDTO(x)).collect(Collectors.toList());
	}


	@Transactional
	public ClientDTO create(ClientDTO objDTO) {
		Client ClientToSave = clientMapper.toModel(objDTO);
		objDTO.setPassword(encoder.encode(objDTO.getPassword()));
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
		objDTO.setId(id);
		objDTO.setPassword(encoder.encode(objDTO.getPassword()));
		
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
