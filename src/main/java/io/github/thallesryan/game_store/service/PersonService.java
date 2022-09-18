package io.github.thallesryan.game_store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import io.github.thallesryan.game_store.domain.dto.PersonRequestDTO;
import io.github.thallesryan.game_store.mapper.PersonMapper;
import io.github.thallesryan.game_store.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public void save(PersonRequestDTO personDTO) {
		personDTO.setPassword(encoder.encode(personDTO.getPassword()));
		repository.save(PersonMapper.INSTANCE.toEntity(personDTO));
	}
}
