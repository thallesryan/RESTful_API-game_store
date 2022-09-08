package io.github.thallesryan.game_store.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class InvalidJwtAuthenticationException extends AuthenticationException{
	
	private static final long serialVersionUID = 1L;
	
	public InvalidJwtAuthenticationException(String ex) {
		super(ex);
	}
}