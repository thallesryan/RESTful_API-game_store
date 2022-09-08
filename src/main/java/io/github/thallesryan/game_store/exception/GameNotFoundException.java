package io.github.thallesryan.game_store.exception;

public class GameNotFoundException extends RuntimeException{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GameNotFoundException(){
		super("Jogo não encontrado.");
	}
}
