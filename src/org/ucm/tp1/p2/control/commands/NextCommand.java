package org.ucm.tp1.p2.control.commands;

import org.ucm.tp1.p2.logic.Game;
import org.ucm.tp1.p3.exception.CommandParseException;

public class NextCommand extends Command{
	
	public NextCommand(String name, String shortCut, String details, String help) {
		super(name,shortCut,details,help);
	}
	
	public boolean execute(Game g) {
		g.update();
		return true;
	}
	
	public Command parse(String tokens[]) throws CommandParseException{
		if( (tokens[0].equalsIgnoreCase("") || tokens[0].equalsIgnoreCase("N") || tokens[0].equalsIgnoreCase("NONE"))){
			if(tokens.length != 1)
				throw new CommandParseException("[ERROR]: " + "Incorrect number of arguments");
			return this;
		}else {
			return null;
		}
	}
}
