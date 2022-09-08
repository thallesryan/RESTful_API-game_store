package io.github.thallesryan.game_store.domain.dto.game;

import java.io.Serializable;

import io.github.thallesryan.game_store.domain.enums.GameGenre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class GameRequestDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private Double preco;
	private Integer qtdeEstoque;
	private GameGenre genre;

}
