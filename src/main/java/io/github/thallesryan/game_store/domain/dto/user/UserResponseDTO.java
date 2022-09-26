package io.github.thallesryan.game_store.domain.dto.user;

import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.github.thallesryan.game_store.domain.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class UserResponseDTO {
	
	private Integer id;
	
	private String name;
	
	private String email;
	
	@JsonFormat(pattern = "dd/MM/yyyy")	
	private LocalDate dt;
	
	private Set<RoleEnum> roles;
	
}
