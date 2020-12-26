package org.ucm.tp1.p2.control.commands;

import org.ucm.tp1.p2.logic.Game;

<<<<<<< HEAD
public class SuperCoinsCommand extends Command{
	public SuperCoinsCommand(String name, String shortCut, String details, String help) {
		super(name,shortCut,details,help);
		
	}
	
	public boolean execute(Game game) {
		if(game.coins()){
			
			return true;
		}else {
			return false;
		}
	}
	
	public Command parse(String tokens[]) {
		if(tokens.length == 1 && (tokens[0].equalsIgnoreCase("C") || tokens[0].equalsIgnoreCase("COINS"))){
			Command c = new SuperCoinsCommand("coins","c","details","help");
			return c;
		}
		else {
			return null;
		}
	}
=======
public class SuperCoinsCommand extends Command {

	public SuperCoinsCommand(String name, String shortCut, String details, String help) {
		super(name, shortCut, details, help);
	}

	public boolean execute(Game game) {
		game.bank(1000);
		return true;
	}

	
	public Command parse(String[] tokens) {
		if(tokens.length == 1 && (tokens[0].equalsIgnoreCase("C") || tokens[0].equalsIgnoreCase("COINS"))){
			return this;
		}else {
			return null;
		}
	}
	
	
>>>>>>> 4cfed7462539d150bc29440279b9920904a0b437
}
