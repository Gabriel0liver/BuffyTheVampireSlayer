package org.ucm.tp1.p2.control.commands;

import org.ucm.tp1.p2.logic.Game;

public class GarlicPushCommand extends Command{
	
	
	public GarlicPushCommand(String name, String shortCut, String details, String help) {
		super(name,shortCut,details,help);
		
	}
	
	public boolean execute(Game game) {
		if(game.garlicPush()){
			game.update();
			return true;
		}else {
			return false;
		}
	}
	
	public Command parse(String tokens[]) {
		if(tokens.length == 1 && (tokens[0].equalsIgnoreCase("G") || tokens[0].equalsIgnoreCase("GARLIC"))){
			Command c = new GarlicPushCommand("garlic","g","details","help");
			return c;
		}
		else {
			return null;
		}
	}
	
		
	}
	
	
	
	


