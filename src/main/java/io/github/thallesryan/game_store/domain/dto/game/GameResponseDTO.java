package io.github.thallesryan.game_store.domain.dto.game;

import java.io.Serializable;

import io.github.thallesryan.game_store.domain.enums.GameGenre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class GameResponseDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Double preco;
	private Integer qtdeEstoque;
	private GameGenre genre;
	
}
