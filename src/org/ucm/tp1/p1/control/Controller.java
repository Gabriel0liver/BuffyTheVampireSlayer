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

    private Game game;
    private Level level;
    private Long seed;
    private Scanner in;
    
    private boolean running;
    private String[] words;
    
    public Controller(Scanner scanner, Level level, Long seed) {
    	this.level = level;
    	this.seed = seed;
	    this.in = scanner;
	    this.game = new Game(this.seed,this.level);
    }
    
    public void  printGame() {
   	 	System.out.println(game);
    }
    
    public void run() {	
    	this.running = true;
    	while(this.running) {// aqui empieza el bucle de la partida.
    		String s = in.nextLine();
    		s = s.trim();
    		this.words = s.split(" +");
    		if(this.words[0].equals("") || this.words[0].equals("n") || this.words[0].equals("none")) {
    			
    		}else if(this.words[0].equals("h") || this.words[0].equals("help")) {
    			System.out.println("Available commands:");
    			System.out.println("[a]dd <x> <y>: add a slayer in position x, y");
    			System.out.println("[h]elp: show this help");
    			System.out.println("[r]eset: reset game");
    			System.out.println("[e]xit: exit game");
    			System.out.println("[n]one | []: update");
    		}else if(this.words[0].equals("a") || this.words[0].equals("add")) {
    			
    		}else if(this.words[0].equals("r") || this.words[0].equals("reset")) {
    			this.game = new Game(this.seed,this.level);
    		}else if(this.words[0].equals("e") || this.words[0].equals("exit")) {
    			System.out.println("Game Over");
    			this.running = false;
    		}
    	}
    }
    

}
