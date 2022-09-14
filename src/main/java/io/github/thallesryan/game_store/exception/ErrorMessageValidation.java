package io.github.thallesryan.game_store.exception;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data @EqualsAndHashCode @AllArgsConstructor @NoArgsConstructor
public class ErrorMessageValidation implements Serializable{
	private static final long serialVersionUID = 1L;

	private String filedName;
	private String message;
	
}
