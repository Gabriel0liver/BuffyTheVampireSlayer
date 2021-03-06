package org.ucm.tp1.p2.control;

import java.util.Scanner;

import org.ucm.tp1.p2.control.commands.Command;
import org.ucm.tp1.p2.control.commands.CommandGenerator;
import org.ucm.tp1.p2.logic.Game;
import org.ucm.tp1.p3.exception.GameException;

public class Controller {

	public final String prompt = "Command >";

	public static final String unknownCommandMsg = String.format("Unknown command");
	public static final String invalidCommandMsg = String.format("Invalid command");
	public static final String invalidPositionMsg = String.format("Invalid position");

	private Game game;
	private Scanner in;

	public Controller(Game game, Scanner scanner) {
		this.game = game;
		this.in = scanner;
	}

	public void run() {
    	
    	boolean refreshDisplay = true;
    	
    	while(!this.game.getGO()) {
    		if (refreshDisplay ) 
    			this.game.draw();
    		refreshDisplay = false;
    		
    		System.out.print(prompt);
    		String word = in.nextLine();
    		System.out.println("[DEBUG] Executing: " + word);
    		String [] words = word.trim().split(" +");

    		try {
    			Command command = CommandGenerator.parse(words);
    			 refreshDisplay = command.execute(game);
    		}
    		catch(GameException ex) {
    			System.out.format(ex.getMessage()+ "%n%n");
    			
    			}
    	}
    	System.out.println("Game Over");
    }

}
