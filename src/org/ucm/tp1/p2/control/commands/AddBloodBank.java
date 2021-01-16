package org.ucm.tp1.p2.control.commands;

import org.ucm.tp1.p2.logic.Game;
import org.ucm.tp1.p3.exception.*;

public class AddBloodBank extends Command {
	private int x;
	private int y;
	private int z;

	public AddBloodBank(int x, int y, int z, String name, String shortCut, String details, String help) {
		super(name, shortCut, details, help);
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public boolean execute(Game g) throws CommandExecuteException {
		try {
			g.addBank(this.x, this.y, this.z);
			g.update();
			return true;
		} catch (NotEnoughCoinsException e) {
			throw new CommandExecuteException("[ERROR]: " + e.getMessage()+"%n"+"[ERROR]: Failed to add bank", e);
		}

		catch (InvalidPositionException e) {
			throw new CommandExecuteException("[ERROR]: " + e.getMessage()+"%n"+"[ERROR]: Failed to add bank", e);
		}
	}

	public Command parse(String tokens[]) throws CommandParseException {
		Command c = null;
		if (tokens[0].equalsIgnoreCase("B") || tokens[0].equalsIgnoreCase("BANK")) {
			if (tokens.length != 4)
				throw new CommandParseException("[ERROR]: " + "Incorrect number of arguments");
			int x, y, z;
			try {
				x = Integer.parseInt(tokens[1]);
				y = Integer.parseInt(tokens[2]);
				z = Integer.parseInt(tokens[3]);
				c = new AddBloodBank(x, y, z, "bank", "b", "details", "help");
			} catch (NumberFormatException exception) {
				throw new CommandParseException("[ERROR]: " + "Unvalid argument for blood bank command, numbers expected: [b]ank <x> <y> <z>"+"%n"+"[ERROR]: Failed to add bank");
			}

		}
		return c;
	}

}
