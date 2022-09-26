package io.github.thallesryan.game_store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.thallesryan.game_store.domain.dto.user.UserResponseDTO;
import io.github.thallesryan.game_store.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<UserResponseDTO> listAll(){
		return userService.findAll();
	}
}
