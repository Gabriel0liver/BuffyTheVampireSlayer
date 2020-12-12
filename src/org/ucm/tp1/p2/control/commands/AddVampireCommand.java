package org.ucm.tp1.p2.control.commands;

import org.ucm.tp1.p2.logic.Game;

public class AddVampireCommand extends Command {

	public AddVampireCommand(String name, String shortCut, String details, String help) {
		super(name, shortCut, details, help);
	}

	public boolean execute(Game game) {
		return true;
	}

	public Command parse(String[] tokens) {
		if ((tokens.length==4 || tokens.length==3) && tokens[0].equalsIgnoreCase("V") && tokens[0].equalsIgnoreCase("VAMPIRE")) {
			Command c = null;
			try {
				int x = Integer.parseInt(tokens[1]);
				int y = Integer.parseInt(tokens[2]);
				c = new AddCommand(x,y,"add","shortCut","details","help");
			}catch(Exception exception) {
				System.out.println("Wronginput!");
			}
			return c;
		}else {
			return null;
		}
		
	}
	
	
}