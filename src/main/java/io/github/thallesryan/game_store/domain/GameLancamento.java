package io.github.thallesryan.game_store.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("lancamento")
public class GameLancamento extends Game {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GameLancamento(String nome, Double preco, int qtd_estoque ) {
		super(nome, preco, qtd_estoque);
	}
}
