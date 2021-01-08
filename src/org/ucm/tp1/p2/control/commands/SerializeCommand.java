package org.ucm.tp1.p2.control.commands;

import org.ucm.tp1.p2.logic.Game;
import org.ucm.tp1.p3.exception.CommandExecuteException;
import org.ucm.tp1.p3.exception.CommandParseException;

public class SerializeCommand extends Command {

	public SerializeCommand(String name, String shortCut, String details, String help) {
		super(name, shortCut, details, help);
	}

	public boolean execute(Game game) throws CommandExecuteException {
		System.out.println(game.serialize());
		return false;
	}

	public Command parse(String[] tokens) throws CommandParseException {
		Command command = null;
		if (tokens[0].equalsIgnoreCase("SERIALIZE") || tokens[0].equalsIgnoreCase("Z")) {
			if (tokens.length != 1) 
				throw new CommandParseException("[ERROR]: " + "Incorrect number of arguments");

			command = new SerializeCommand("serialize","z","details","help");
			return command;
				
		}
		return command;
	}

}
