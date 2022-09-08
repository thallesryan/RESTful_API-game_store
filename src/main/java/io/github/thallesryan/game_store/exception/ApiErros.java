package io.github.thallesryan.game_store.exception;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import lombok.Data;
import lombok.Getter;

/**
 * Serve para exibir os erros em formato de objeto, que será exibido como JSON*/
@Data
public class ApiErros {
	
	@Getter
	List<String> erros;
	
	public ApiErros(String mensagem) {
		this.erros = Collections.singletonList(mensagem);
	}
	
	public ApiErros(List<String> mensagens) {
		this.erros = mensagens;
	}
}
