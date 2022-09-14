package io.github.thallesryan.game_store.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;

	private List<ErrorMessageValidation> errors = new ArrayList<>();

	public ValidationError() {
		super();
	}

	public ValidationError(Long timestamp, Integer status, String error, String message, String path) {
		super(timestamp, status, error, message, path);
	}

	public List<ErrorMessageValidation> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String message) {
		this.errors.add(new ErrorMessageValidation(fieldName, message));
	}

}
