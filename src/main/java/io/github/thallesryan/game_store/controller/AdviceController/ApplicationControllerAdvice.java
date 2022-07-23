package io.github.thallesryan.game_store.controller.AdviceController;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.github.thallesryan.game_store.exception.ApiErros;
import io.github.thallesryan.game_store.exception.JogoNaoEncontradoException;

@RestControllerAdvice
public class ApplicationControllerAdvice {
	
	/**
	 * Lida com os erros lançados do tipo JogoNaoEncontradoException
	 * @author Thalles
	 * @param JogoNaoEncontradoException
	 * @return ApiErros*/
	@ExceptionHandler(JogoNaoEncontradoException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErros handleJogoNaoEncontradoException(JogoNaoEncontradoException ex) {
		 return new ApiErros(ex.getMessage());
	}
	
	/**
	 *Lida com todos os erros gerados pelas Constraints/validações
	 * @param MethodArgumentNotValidException
	 * @return ApiErros*/
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErros handleMethodAtgumentNotValidException(MethodArgumentNotValidException ex) {
		
		List<String> errosNasValidacoes =  ex.getBindingResult().getAllErrors().stream().map(erro -> erro.getDefaultMessage()).collect(Collectors.toList());
		return new ApiErros(errosNasValidacoes);
	}

}
