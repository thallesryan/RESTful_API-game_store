package io.github.thallesryan.game_store.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import io.github.thallesryan.game_store.domain.UserModel;
import io.github.thallesryan.game_store.domain.dto.user.UserRequestDTO;
import io.github.thallesryan.game_store.domain.dto.user.UserResponseDTO;
import io.github.thallesryan.game_store.mapper.UserMapper;
import io.github.thallesryan.game_store.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public void save(UserRequestDTO personDTO) {
		personDTO.setPassword(encoder.encode(personDTO.getPassword()));
		repository.save(UserMapper.INSTANCE.toEntity(personDTO));
	}
	
	public UserResponseDTO find(String email) {
		UserModel user = repository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));
		UserResponseDTO userResponse = UserMapper.INSTANCE.toResponseDTO(user);
		return userResponse;
	}
	
	public List<UserResponseDTO> findAll(){
		 return this.repository.findAll().stream().map(user -> {
			 return UserMapper.INSTANCE.toResponseDTO(user);
		 }).collect(Collectors.toList());
	}
	
}
