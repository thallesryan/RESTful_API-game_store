package io.github.thallesryan.game_store.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("lancamento")
public class JogoLancamento extends Jogo{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JogoLancamento(String nome, Double preco,int qtd_estoque ) {
		super(nome, preco, qtd_estoque);
	}
}
