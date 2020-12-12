package org.ucm.tp1.p2.control.commands;

import org.ucm.tp1.p2.logic.Game;

public class LightFlashCommand extends Command{
		
	public LightFlashCommand(String name, String shortCut, String details, String help) {
		super(name,shortCut,details,help);
		
	}
	
	public boolean execute(Game game) {
		if(game.lightFlash()){
			game.update();
			return true;
		}else {
			return false;
		}
	}
	
	public Command parse(String tokens[]) {
		if(tokens.length == 1 && (tokens[0].equalsIgnoreCase("L") || tokens[0].equalsIgnoreCase("LIGHT"))){
			Command c = new LightFlashCommand("light","l","details","help");
			return c;
		}
		else {
			return null;
		}
	}
	
		
}
