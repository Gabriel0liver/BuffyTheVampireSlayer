package org.ucm.tp1.p2.control.commands;

import org.ucm.tp1.p2.logic.Game;

public class AddBloodBank extends Command{
	private int x;
	private int y;
	private int z;
	public AddBloodBank(int x, int y,int z,String name, String shortCut, String details, String help) {
		super(name,shortCut,details,help);
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public boolean execute(Game g) {
		if(g.addBank(this.x, this.y,this.z)){
			g.update();
			return true;
		}else {
			System.out.println("Invalid position");
			return false;
		}
	}
	
	public Command parse(String tokens[]) {
		if(tokens.length == 4 && (tokens[0].equalsIgnoreCase("B") || tokens[0].equalsIgnoreCase("BANK"))){
			int x = Integer.parseInt(tokens[1]);
			int y = Integer.parseInt(tokens[2]);
			int z = Integer.parseInt(tokens[3]);
			Command c = new AddBloodBank(x,y,z,"bank","b","details","help");
			return c;
		}
		else {
			return null;
		}
	}

}
