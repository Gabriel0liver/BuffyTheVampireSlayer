package org.ucm.tp1.p2.control.commands;

import org.ucm.tp1.p2.logic.Game;
import org.ucm.tp1.p3.exception.*;

public class LightFlashCommand extends Command{
		
	public LightFlashCommand(String name, String shortCut, String details, String help) {
		super(name,shortCut,details,help);
		
	}
	
	public boolean execute(Game game) throws CommandExecuteException{
		
		try {
			game.lightFlash();
			game.update();
				return true;
		}
		catch(NotEnoughCoinsException e) {	
			throw new CommandExecuteException("[ERROR]: " +e.getMessage(), e);
		}
		
	}
	
	public Command parse(String tokens[]) throws CommandParseException{
		
		Command c = null;
		if (tokens[0].equalsIgnoreCase("L") || tokens[0].equalsIgnoreCase("LIGHT")) {
			if (tokens.length == 1) {
				c = new LightFlashCommand("light","l","details","help");

			} else {
				throw new CommandParseException("[ERROR]: " + "Incorrect number of arguments");
			}
		}
		return c;
	}
	
		
}
