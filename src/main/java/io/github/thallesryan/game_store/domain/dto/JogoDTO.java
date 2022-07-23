package io.github.thallesryan.game_store.domain.dto;

import io.github.thallesryan.game_store.domain.JogoCategoriaEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class JogoDTO {

	
	private String nome;
	private Double preco;
	private Integer qtdeEstoque;
	
	
	
	
}
