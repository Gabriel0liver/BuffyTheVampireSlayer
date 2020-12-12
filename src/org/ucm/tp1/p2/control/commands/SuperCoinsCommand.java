package org.ucm.tp1.p2.control.commands;

import org.ucm.tp1.p2.logic.Game;

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
	
	
}
