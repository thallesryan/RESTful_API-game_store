package io.github.thallesryan.game_store.domain.dto.user;

import java.util.Set;

import io.github.thallesryan.game_store.domain.enums.RoleEnum;

public class UserResponseDTO {
	
	private String name;
	
	private String email;
	
	private Set<RoleEnum> roles;
	
}
