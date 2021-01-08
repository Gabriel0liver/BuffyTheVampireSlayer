package org.ucm.tp1.p3.exception;

public class GameException extends Exception{
	public GameException() {
		super(); 
	}
	public GameException(String message) {
		super(message);
	}
	
	public GameException(String message,Throwable cause) {
		super(message, cause);
	}
}
