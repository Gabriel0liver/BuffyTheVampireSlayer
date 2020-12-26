package org.ucm.tp1.p2.control.commands;

import org.ucm.tp1.p2.logic.Game;
import org.ucm.tp1.p2.logic.Level;

public class ResetCommand extends Command{
	
	public ResetCommand(String name, String shortCut, String details, String help) {
		super(name,shortCut,details,help);
	}
	
	public boolean execute(Game g) {
		g.resetGame();
		return true;
	}
	
	public Command parse(String tokens[]) {
		if(tokens.length == 1 && (tokens[0].equalsIgnoreCase("RESET") || tokens[0].equalsIgnoreCase("R"))){
			return this;
		}else {
			return null;
		}
	}
}
