package org.ucm.tp1.p1.control;

import java.util.Scanner;
import org.ucm.tp1.p1.logic.Game;
import org.ucm.tp1.p1.logic.Level;

public class Controller {

	
	public final String prompt = "Command > ";
	public static final String helpMsg = String.format(
			"Available commands:%n" +
			"[a]dd <x> <y>: add a slayer in position x, y%n" +
			"[h]elp: show this help%n" + 
			"[r]eset: reset game%n" + 
			"[e]xit: exit game%n"+ 
			"[n]one | []: update%n");
	
	public static final String unknownCommandMsg = String.format("Unknown command");
	public static final String invalidCommandMsg = String.format("Invalid command");
	public static final String invalidPositionMsg = String.format("Invalid position");
	public static final String debugCommandMsg = String.format("%n[DEBUG] Executing: ");

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
    		System.out.print("Command >");
    		String s = in.nextLine();
    		s = s.trim();
    		System.out.println(Controller.debugCommandMsg + s);
    		String [] words = s.split(" +");
    		words[0] = words[0].toLowerCase();
    		if(words[0].equals("") || words[0].equals("n") || words[0].equals("none")) {
    			this.game.update();
    			this.game.draw();
    		}
    		else if(words[0].equals("h") || words[0].equals("help")) {
    			System.out.println(this.helpMsg);
    		}
    		else if(words[0].equals("a") || words[0].equals("add")) {
    			int x;
    			int y;
    			try {
    				x = Integer.parseInt(words[1]);
    				y = Integer.parseInt(words[2]);
    			}
    			catch(Exception exception) {
    				System.out.println("[ERROR]: Invalidposition");
    				break;
    			}
    			if(this.game.addSlayer(x,y)) {
    				this.game.update();
    				this.game.draw();
    			}else {
    				System.out.println();
    				System.out.println("[ERROR]: Invalidposition");
    				System.out.println();
    			}
    		}
    		else if(words[0].equals("r") || words[0].equals("reset")) {
    			this.game = new Game(this.game.seed,this.game.level);
    			this.game.draw();
    		}
    		else if(words[0].equals("e") || words[0].equals("exit")) {
    			this.game.setGO(true);
    		}
    	}
    	System.out.println("Game Over");
    }
    

}
