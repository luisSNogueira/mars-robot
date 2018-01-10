package br.com.mars.exception;

public class InvalidMovementException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8843548406086105096L;

	public InvalidMovementException() {
		
	}
	
	public InvalidMovementException(String message) {
		super(message);
	}
	
	public InvalidMovementException(Throwable cause) {
		super(cause);
	}
	
	public InvalidMovementException(String message, Throwable cause) {
		super(message, cause);
	}

}
