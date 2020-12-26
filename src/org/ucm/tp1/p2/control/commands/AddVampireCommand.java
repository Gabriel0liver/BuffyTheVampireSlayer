package org.ucm.tp1.p2.control.commands;

import org.ucm.tp1.p2.logic.Game;

<<<<<<< HEAD
public class AddVampireCommand extends Command{
	private int x;
	private int y;
	
	public AddVampireCommand(int x, int y, String name, String shortCut, String details, String help) {
		super(name,shortCut,details,help);
		this.x = x;
		this.y = y;
	}
	
	
	
	public boolean execute(Game g) {
		if(g.addV(this.x, this.y)){
			g.update();
			return true;
		}else {
			return false;
		}
	}
	
	public Command parse(String tokens[]) {
		if (tokens.length!=3) return null;
		if (!tokens[0].equalsIgnoreCase("VAMPIRE") && !tokens[0].equalsIgnoreCase("V")) return null;
		Command c = null;
		try {
			int x = Integer.parseInt(tokens[1]);
			int y = Integer.parseInt(tokens[2]);
			c = new AddVampireCommand(x,y,"vampire","v","details","help");
		}catch(Exception exception) {
			System.out.println("Wronginput!");
		}
		return c;
	}
	
}
=======
public class AddVampireCommand extends Command {
	
	private int x;
	private int y;
	private static String[] types = {"v","d","e"};

	public AddVampireCommand(int x, int y, String name, String shortCut, String details, String help) {
		super(name, shortCut, details, help);
		this.x = x;
		this.y = y;
	}

	public boolean execute(Game game) {
		if(game.addCustomVampire(x, y, this.shortCut)) {
		return true;
		}
		else {
			System.out.println("Invalid position");
			return false;
		}
	}

	public Command parse(String[] tokens) {
		if(tokens[0].equalsIgnoreCase("V") || tokens[0].equalsIgnoreCase("VAMPIRE")) {
			Command c = null;
			if(tokens.length==4) {
				for(String type:types) {
					if(tokens[1].equalsIgnoreCase(type)) {
						int x = Integer.parseInt(tokens[2]);
						int y = Integer.parseInt(tokens[3]);
						c = new AddVampireCommand(x,y,"vampire",type,"details","help");
					}
				}
			}else if( tokens.length==3) {
				int x = Integer.parseInt(tokens[1]);
				int y = Integer.parseInt(tokens[2]);
				c = new AddVampireCommand(x,y,"vampire","v","details","help");
			}
			return c;
		}else {
			return null;
		}
		
	}
	
	
}

