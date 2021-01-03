package org.ucm.tpq.p3.exception;

public class CommandParseException extends GameException{
	public CommandParseException() { 
		super(); 
	}
	
	public CommandParseException(String message) {
		super(message);
	}
	
	public CommandParseException(String message, Throwable cause) {
		super(message, cause);
	} 
}
