package io.github.thallesryan.game_store.domain;

public enum JogoCategoriaEnum {
	
	REGULAR("regular"),
	LANCAMENTO("lancamento");

	public String valor;
	
	JogoCategoriaEnum(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return this.valor;
	}
}
