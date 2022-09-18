package io.github.thallesryan.game_store.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class CredentialsDTO {

	private String email;
	private String password;

}
