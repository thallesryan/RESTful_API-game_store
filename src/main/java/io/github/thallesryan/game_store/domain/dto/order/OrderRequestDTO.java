package io.github.thallesryan.game_store.domain.dto.order;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class OrderRequestDTO {
	
	private Set<ItemRequestDTO> items;
	
}
