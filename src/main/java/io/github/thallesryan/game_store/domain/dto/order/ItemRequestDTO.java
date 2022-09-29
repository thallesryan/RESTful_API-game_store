package io.github.thallesryan.game_store.domain.dto.order;

import io.github.thallesryan.game_store.domain.dto.game.GameRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode
public class ItemRequestDTO {

	private GameRequestDTO game;
	private Integer quantity;
	
	public Integer getQuantity() {
		return this.quantity == null ? 1 : this.quantity;
	}
}
