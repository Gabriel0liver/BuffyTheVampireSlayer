package org.ucm.tp1.p3.exception;

public class InvalidPositionException extends CommandExecuteException {

	public InvalidPositionException() { 
		super(); 
	}
	
	public InvalidPositionException(String message) {
		super(message);
	}
	
	public InvalidPositionException(String message, Throwable cause) {
		super(message, cause);
	}
}
