package br.com.mars.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ResponseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1544116923680392681L;
	
	public ResponseException(String message) {
		super(message);
	}
	
	public ResponseException(Throwable cause) {
		super(cause);
	}
	
	public ResponseException(String message, Throwable cause) {
		super(message, cause);
	}

}
