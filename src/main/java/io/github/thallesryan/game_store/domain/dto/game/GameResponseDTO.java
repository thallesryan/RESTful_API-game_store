package io.github.thallesryan.game_store.domain.dto.game;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import io.github.thallesryan.game_store.domain.enums.GameGenre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class GameResponseDTO extends RepresentationModel<GameResponseDTO> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private Double price;
	private Integer quantity;
	private GameGenre genre;
	
}
