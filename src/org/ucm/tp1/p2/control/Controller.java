package org.ucm.tp1.p2.control;

import java.util.Scanner;

import org.ucm.tp1.p1.control.commands.Command;
import org.ucm.tp1.p1.control.commands.CommandGenerator;
import org.ucm.tp1.p1.logic.Game;
import org.ucm.tp1.p1.logic.Level;

public class Controller {

	
	public final String prompt = "Command >";

	public static final String unknownCommandMsg = String.format("Unknown command");
	public static final String invalidCommandMsg = String.format("Invalid command");
	public static final String invalidPositionMsg = String.format("Invalid position");

    private Game game;
    private Scanner in;
    
    private boolean running;
    
    public Controller(Game game, Scanner scanner) {
    	this.game = game;
	    this.in = scanner;
    }
    
    public void run() {
    	this.game.draw();
    	while(!this.game.getGO()) {
    		System.out.print(prompt);
    		String [] words = in.nextLine().trim().split(" +");
    		Command command = CommandGenerator.parseCommand(words);
    		if(command != null) {
    			if(command.execute(game)) {
    				this.game.draw();
    			}
    		}else {
    			System.out.println(invalidCommandMsg);
    		}
    	}
    	System.out.println("Game Over");
    }
    

}
