package org.ucm.tp1.p1.control.commands;

import org.ucm.tp1.p1.logic.Game;

public class NextCommand extends Command{
	
	public NextCommand(String name, String shortCut, String details, String help) {
		super(name,shortCut,details,help);
	}
	
	public boolean execute(Game g) {
		g.update();
		return true;
	}
	
	public Command parse(String tokens[]) {
		if(tokens.length == 1 && (tokens[0].equalsIgnoreCase("") || tokens[0].equalsIgnoreCase("N") || tokens[0].equalsIgnoreCase("NONE"))){
			return this;
		}else {
			return null;
		}
	}
}
