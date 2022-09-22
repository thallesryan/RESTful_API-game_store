package io.github.thallesryan.game_store.domain.dto.order;

import java.time.LocalDate;
import java.util.Set;

import io.github.thallesryan.game_store.domain.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class OrderResponseDTO {

	private Integer id;
	
	private LocalDate date;
	
	private Set<Item> itens;
	
	private Double total;
}
