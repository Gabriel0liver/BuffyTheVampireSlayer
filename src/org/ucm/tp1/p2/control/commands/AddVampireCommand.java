package org.ucm.tp1.p2.control.commands;

import org.ucm.tp1.p2.logic.Game;
import org.ucm.tp1.p3.exception.*;

public class AddVampireCommand extends Command {
	
	private int x;
	private int y;
	private static String[] types = {"v","d","e"};

	public AddVampireCommand(int x, int y, String name, String shortCut, String details, String help) {
		super(name, shortCut, details, help);
		this.x = x;
		this.y = y;
	}

	public boolean execute(Game game)throws CommandExecuteException {
		
		try {
			game.addCustomVampire(x, y, this.shortCut);
			return true;
		}
		catch(InvalidPositionException e) {
			throw new CommandExecuteException( "[ERROR]: "+e.getMessage()+"%n"+"[ERROR]: Failed to add vampire", e);
		}
		catch(NoMoreVampiresException e) {
			throw new CommandExecuteException( "[ERROR]: "+e.getMessage()+"%n"+"[ERROR]: Failed to add vampire", e);
		}
		catch(DraculaIsAliveException e) {
			throw new CommandExecuteException( "[ERROR]: "+e.getMessage()+"%n"+"[ERROR]: Failed to add vampire", e);
		}
	}

	public Command parse(String[] tokens) throws CommandParseException{
		Command c = null;
		if(tokens[0].equalsIgnoreCase("V") || tokens[0].equalsIgnoreCase("VAMPIRE")) {
			
			if(tokens.length==4) {
				for(String type:types) {
					if(tokens[1].equalsIgnoreCase(type)) {
						int x,y;
						try {
						 x = Integer.parseInt(tokens[2]);
						 y = Integer.parseInt(tokens[3]);
						c = new AddVampireCommand(x,y,"vampire",type,"details","help");
						}
						catch(NumberFormatException exception) {
							throw new CommandParseException("[ERROR]: " + "Unvalid argument for add vampire command, number expected: [v]ampire [<type>] <x> <y>. Type = {\"\"|\"D\"|\"E\"}"+"%n"+"[ERROR]: Failed to add vampire");
						}
					}
				}
				if(c==null)
					throw new CommandParseException("[ERROR]: Unvalid type: [v]ampire [<type>] <x> <y>. Type = {\"\"|\"D\"|\"E\"}"+"%n"+"[ERROR]: Failed to add vampire");
				
			}
			
			else if( tokens.length==3) {
				int x,y;
				try {
					
					x = Integer.parseInt(tokens[1]);
					y = Integer.parseInt(tokens[2]);
				}
				catch(NumberFormatException exception) {
					throw new CommandParseException("[ERROR]: " + "You can't put decimals"+"%n"+"[ERROR]: Failed to add vampire");
				}
				c = new AddVampireCommand(x,y,"vampire","v","details","help");
			}
			else {
				throw new CommandParseException("[ERROR]: " + "Incorrect number of arguments"+"%n"+"[ERROR]: Failed to add vampire");
			}
			
		}
		
		return c;
	}

}