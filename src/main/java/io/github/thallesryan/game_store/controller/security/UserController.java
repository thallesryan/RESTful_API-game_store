package io.github.thallesryan.game_store.controller.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.thallesryan.game_store.domain.dto.security.UserModelDTO;
import io.github.thallesryan.game_store.domain.security.UserModel;
import io.github.thallesryan.game_store.mapper.UserMapper;
import io.github.thallesryan.game_store.service.security.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("gamestore/user")
@RequiredArgsConstructor
public class UserController {

	private UserDetailsServiceImpl userService;
	private BCryptPasswordEncoder encoder;
	
	public void save(@RequestBody UserModelDTO userDTO) {
		String senhaCriptografada = encoder.encode(userDTO.getPassword());
		userDTO.setPassword(senhaCriptografada);
		
		UserModel entity = UserMapper.INSTANCE.toEntity(userDTO);
	
		
		userService.save(entity);
	}
	
}
