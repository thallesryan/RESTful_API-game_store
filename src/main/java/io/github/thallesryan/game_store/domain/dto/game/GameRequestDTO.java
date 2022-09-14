package io.github.thallesryan.game_store.domain.dto.game;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

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
	
	@NotEmpty(message = "Nome não pode estar vazio.")
	@Column(name = "nome", length = 100)
	private String nome;
	
	@Positive(message = "Preço tem que ser Positivo e maior que zero.")
	@NotNull(message = "Preço não pode estar vazio.")
	private Double preco;
	
	@PositiveOrZero(message = "Estoque não pode ser negativo.")
	private Integer qtdeEstoque;
	
	private GameGenre genre;

}
