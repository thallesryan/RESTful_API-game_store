package io.github.thallesryan.game_store.domain.dto.order;

import java.util.Set;

import io.github.thallesryan.game_store.domain.dto.user.UserRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class OrderRequestDTO {
	
	private UserRequestDTO user;
	private Set<ItemRequestDTO> items;
	private Double total;
	
}
