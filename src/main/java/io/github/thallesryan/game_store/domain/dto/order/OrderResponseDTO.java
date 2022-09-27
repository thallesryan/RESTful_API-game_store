package io.github.thallesryan.game_store.domain.dto.order;

import java.time.LocalDate;
import java.util.Set;

import io.github.thallesryan.game_store.domain.Item;
import io.github.thallesryan.game_store.domain.dto.user.UserResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class OrderResponseDTO {

	private Integer id;
	
	private UserResponseDTO user;
	
	private LocalDate date;
	
	private Set<Item> itens;
	
	private Double total;
}
