package org.ucm.tp1.p3.exception;

public class CommandExecuteException extends GameException{

	public CommandExecuteException() { 
		super(); 
	}
	
	public CommandExecuteException(String message) {
		super(message);
	}
	
	public CommandExecuteException(String message, Throwable cause) {
		super(message, cause);
	} 
	
	
	
}
