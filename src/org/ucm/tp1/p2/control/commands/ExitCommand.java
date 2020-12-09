package org.ucm.tp1.p2.control.commands;

import org.ucm.tp1.p1.logic.Game;

public class ExitCommand extends Command{
	
	public ExitCommand(String name, String shortCut, String details, String help) {
		super(name,shortCut,details,help);
	}
	
	public boolean execute(Game g) {
		g.setGO(true);
		return false;
	}
	
	public Command parse(String tokens[]) {
		if(tokens.length == 1 && (tokens[0].equalsIgnoreCase("E") || tokens[0].equalsIgnoreCase("EXIT"))){
			return this;
		}else {
			return null;
		}
	}
}
