package org.ucm.tp1.p2.control.commands;

import org.ucm.tp1.p2.logic.Game;

public class HelpCommand extends Command {
	
	private static final String helpMsg = String.format(
			"%n[a]dd <x> <y>: add a slayer in position x, y%n" +
			"[h]elp: show this help%n" + 
			"[r]eset: reset game%n" + 
			"[e]xit: exit game%n"+ 
			"[n]one | []: update%n" +
			"[g]arlic: push back vampires%n"+
			"[l]ight: eliminate all vampires (but dracula survive)%n"+
<<<<<<< HEAD
			"[B]ank <x> <y> <z>: returns 10% of your investment%n "+
			"[v]ampire <x> <y>: add a sayer in position x, y%n");
=======
			"[v]ampire <type> <x> <y>: add a vampire in x, y");
	
	
>>>>>>> 4cfed7462539d150bc29440279b9920904a0b437
	
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
