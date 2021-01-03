package org.ucm.tpq.p3.exception;

public class NotEnoughCoinsException extends CommandExecuteException{

	public NotEnoughCoinsException() { 
		super(); 
	}
	
	public NotEnoughCoinsException(String message) {
		super(message);
	}
	
	public NotEnoughCoinsException(String message, Throwable cause) {
		super(message, cause);
	} 
}
