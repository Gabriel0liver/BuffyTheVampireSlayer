package org.ucm.tpq.p3.exception;

public class UnvalidPositionException extends CommandExecuteException {

	public UnvalidPositionException() { 
		super(); 
	}
	
	public UnvalidPositionException(String message) {
		super(message);
	}
	
	public UnvalidPositionException(String message, Throwable cause) {
		super(message, cause);
	}
}
