package org.ucm.tp1.p1.control.commands;

import org.ucm.tp1.p1.logic.Game;

public class HelpCommand extends Command {
	
	private static final String helpMsg = String.format(
			"%n[a]dd <x> <y>: add a slayer in position x, y%n" +
			"[h]elp: show this help%n" + 
			"[r]eset: reset game%n" + 
			"[e]xit: exit game%n"+ 
			"[n]one | []: update%n");
	
	public HelpCommand(String name, String shortCut, String details, String help) {
		super(name,shortCut,details,help);
	}
	
	public boolean execute(Game g) {
		System.out.print(this.helpText());
		return false;
	}
	
	public Command parse(String tokens[]) {
		if(tokens.length == 1 && (tokens[0].equalsIgnoreCase("H") || tokens[0].equalsIgnoreCase("HELP"))){
			Command c = new HelpCommand("help","h","Available commands",helpMsg);
			return c;
		}else {
			return null;
		}
	}
}
