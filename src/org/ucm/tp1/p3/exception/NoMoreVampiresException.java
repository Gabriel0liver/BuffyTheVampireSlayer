package org.ucm.tp1.p3.exception;

public class NoMoreVampiresException extends CommandExecuteException{
	public NoMoreVampiresException() { 
		super(); 
	}
	
	public NoMoreVampiresException(String message) {
		super(message);
	}
	
	public NoMoreVampiresException(String message, Throwable cause) {
		super(message, cause);
	}
}
