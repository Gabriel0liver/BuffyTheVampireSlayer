package org.ucm.tp1.p2.control.commands;

import org.ucm.tp1.p2.logic.Game;
import org.ucm.tp1.p3.exception.*;

public class AddCommand extends Command {
	private int x;
	private int y;

	public AddCommand(int x, int y, String name, String shortCut, String details, String help) {
		super(name, shortCut, details, help);
		this.x = x;
		this.y = y;
	}

	public boolean execute(Game g) throws CommandExecuteException {
		try{
			g.addSlayer(this.x, this.y); 
			g.update();
			return true;
		}
		catch(NotEnoughCoinsException e) {
			
			throw new CommandExecuteException("[ERROR]: " +e.getMessage(), e);
		}
		catch(InvalidPositionException e) {
			
			throw new CommandExecuteException( "[ERROR]: "+e.getMessage(), e);
		}
		
		
	}
	/*
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
	  */

	public Command parse(String[] tokens) throws CommandParseException {
		Command command = null;
		if (tokens[0].equalsIgnoreCase("ADD") || tokens[0].equalsIgnoreCase("A")) {
			
			if (tokens.length != 3) 
				throw new CommandParseException("[ERROR]: " + "Incorrect number of arguments");
		
			else {
					int x; int y;
					try {
						if(Integer.parseInt(tokens[1]) %2 !=0 || Integer.parseInt(tokens[2])%2 !=0)
							throw new NumberFormatException("there are decimals in the commands");
						x = Integer.parseInt(tokens[1]);
						y = Integer.parseInt(tokens[2]);
					}
					catch(NumberFormatException exception) {
						throw new CommandParseException("[ERROR]: " + exception.getMessage());
					}
					command = new AddCommand(x, y,"add","shortCut","details","help");
				}
		}
		return command;
	}
	
	
	
	
	
	
	}
