package io.github.thallesryan.game_store.controller.AdviceController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.github.thallesryan.game_store.exception.ErrorMessage;
import io.github.thallesryan.game_store.exception.GameNotFoundException;
import io.github.thallesryan.game_store.exception.StandardError;
import io.github.thallesryan.game_store.exception.ValidationError;

@RestControllerAdvice
public class ApplicationControllerAdvice {
	
	/**
	 * Lida com os erros lançados do tipo JogoNaoEncontradoException
	 * @author Thalles
	 * @param JogoNaoEncontradoException
	 * @return ApiErros*/
	@ExceptionHandler(GameNotFoundException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage handleJogoNaoEncontradoException(GameNotFoundException ex) {
		 return new ErrorMessage(ex.getMessage());
	}
	
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
	
	@ExceptionHandler(BadCredentialsException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage handleBadCredentialsException(BadCredentialsException e) {
		return new ErrorMessage(e.getMessage());
	}

}
