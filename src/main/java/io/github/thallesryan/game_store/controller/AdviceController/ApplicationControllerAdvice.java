package io.github.thallesryan.game_store.controller.AdviceController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.github.thallesryan.game_store.exception.StandardError;
import io.github.thallesryan.game_store.exception.ValidationError;

@RestControllerAdvice
public class ApplicationControllerAdvice {
	
	/**
	 * Lida com os erros lançados do tipo JogoNaoEncontradoException
	 * @author Thalles
	 * @param JogoNaoEncontradoException
	 * @return ApiErros*/
//	@ExceptionHandler(GameNotFoundException.class)
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	public message handleJogoNaoEncontradoException(GameNotFoundException ex) {
//		 return new ApiErros(ex.getMessage());
//	}
	
	/**
	 *Lida com todos os erros gerados pelas Constraints/validações
	 * @param MethodArgumentNotValidException
	 * @return ApiErros*/
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	public ApiErros handleMethodAtgumentNotValidException(MethodArgumentNotValidException ex) {
//		
//		List<String> errosNasValidacoes =  ex.getBindingResult().getAllErrors().stream().map(erro -> erro.getDefaultMessage()).collect(Collectors.toList());
//		return new ApiErros(errosNasValidacoes);
//	}
//	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validationErrors(MethodArgumentNotValidException ex,
			HttpServletRequest request) {

		ValidationError errors = new ValidationError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), 
				"Validation error", "Erro na validação dos campos", request.getRequestURI());
		
//		for(FieldError x : ex.getBindingResult().getFieldErrors()) {
//			errors.addError(x.getField(), x.getDefaultMessage());
//		}

		ex.getBindingResult().getFieldErrors().stream().forEach(erro -> errors.addError(erro.getField(),erro.getDefaultMessage()));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}

}
