package io.github.thallesryan.game_store.exception;

public class JogoNaoEncontradoException extends RuntimeException{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JogoNaoEncontradoException(){
		super("Jogo não encontrado.");
	}
}
