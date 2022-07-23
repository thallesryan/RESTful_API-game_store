package io.github.thallesryan.game_store.exception;

public class PedidoNaoEncontradoException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PedidoNaoEncontradoException() {
		super("O Pedido não foi encontrado.");
	}

}
