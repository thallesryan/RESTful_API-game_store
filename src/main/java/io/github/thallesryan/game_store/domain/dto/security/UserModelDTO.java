package io.github.thallesryan.game_store.domain.dto.security;

import java.util.List;

import io.github.thallesryan.game_store.domain.security.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class UserModelDTO {

	private String username;
	private String password;
	private List<Role> roles;
}
