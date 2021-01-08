package org.ucm.tp1.p2.control.commands;

import org.ucm.tp1.p2.logic.Game;
import org.ucm.tp1.p3.exception.*;

public class GarlicPushCommand extends Command {

	public GarlicPushCommand(String name, String shortCut, String details, String help) {
		super(name, shortCut, details, help);

	}

	public boolean execute(Game game) throws CommandExecuteException {

		try {
			game.garlicPush();
			game.update();
			return true;
		} catch (NotEnoughCoinsException e) {
			throw new CommandExecuteException("[ERROR]: " + e.getMessage(), e);
		}

	}

	public Command parse(String tokens[]) throws CommandParseException {
		Command c = null;
		if (tokens[0].equalsIgnoreCase("G") || tokens[0].equalsIgnoreCase("GARLIC")) {
			if (tokens.length != 1)
				throw new CommandParseException("[ERROR]: " + "Incorrect number of arguments");
				
			c = new GarlicPushCommand("garlic", "g", "details", "help");

			
		}
		return c;
	}

}
