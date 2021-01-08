package org.ucm.tp1.p2.control.commands;

import org.ucm.tp1.p2.logic.Game;
import org.ucm.tp1.p3.exception.CommandParseException;

public class HelpCommand extends Command {
	
	private static final String helpMsg = String.format(
			"%n[a]dd <x> <y>: add a slayer in position x, y%n" +
			"[h]elp: show this help%n" + 
			"[r]eset: reset game%n" + 
			"[e]xit: exit game%n"+ 
			"[n]one | []: update%n" +
			"[g]arlic: push back vampires%n"+
			"[l]ight: eliminate all vampires (but dracula survive)%n"+
			"[v]ampire <type> <x> <y>: add a vampire in x, y");
	
	
	
	public HelpCommand(String name, String shortCut, String details, String help) {
		super(name,shortCut,details,help);
	}
	
	public boolean execute(Game g) {
		System.out.print(this.helpText());
		return false;
	}
	
	public Command parse(String tokens[])throws CommandParseException {
		if(  (tokens[0].equalsIgnoreCase("H") || tokens[0].equalsIgnoreCase("HELP"))){
			if (tokens.length != 1)
				throw new CommandParseException("[ERROR]: " + "Incorrect number of arguments");
			
			Command c = new HelpCommand("help","h","Available commands",helpMsg);
			return c;
			
		}else {
			return null;
		}
	}
}
