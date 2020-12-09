package org.ucm.tp1.p2.control.commands;

import org.ucm.tp1.p2.logic.Game;

public class AddCommand extends Command{
	private int x;
	private int y;
	
	public AddCommand(int x, int y, String name, String shortCut, String details, String help) {
		super(name,shortCut,details,help);
		this.x = x;
		this.y = y;
	}
	
	
	
	public boolean execute(Game g) {
		if(g.addSlayer(this.x, this.y)){
			g.update();
			return true;
		}else {
			return false;
		}
	}
	
	public Command parse(String tokens[]) {
		if (tokens.length!=3) return null;
		if (!tokens[0].equalsIgnoreCase("ADD") && !tokens[0].equalsIgnoreCase("A")) return null;
		Command c = null;
		try {
			int x = Integer.parseInt(tokens[1]);
			int y = Integer.parseInt(tokens[2]);
			c = new AddCommand(x,y,"add","shortCut","details","help");
		}catch(Exception exception) {
			System.out.println("Wronginput!");
		}
		return c;
	}
}
