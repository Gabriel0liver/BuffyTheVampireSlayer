package org.ucm.tp1.p2.control.commands;

import org.ucm.tp1.p2.logic.Game;
import org.ucm.tp1.p3.exception.*;

public abstract class Command {
	protected final String name;
	protected final String shortCut;
	private final String details;
	private final String help;

	protected static final String incorrectNumArgsMsg = "Incorrect number of arguments";
	protected static final String incorrectArgsMsg = "Incorrect argument format";

	public Command(String name, String shortCut, String details, String help) {
		this.name = name;
		this.shortCut = shortCut;
		this.details = details;
		this.help = help;
	}

	public abstract boolean execute(Game game) throws CommandExecuteException;

	public abstract Command parse(String[] commandWords) throws CommandParseException;

	protected boolean matchCommandName(String name) {
		return this.shortCut.equalsIgnoreCase(name) || this.name.equalsIgnoreCase(name);
	}

	protected Command parseNoParamsCommand(String[] words) throws CommandParseException {
		if (matchCommandName(words[0])) {
			if (words.length != 1)
				throw new CommandParseException("[ERROR]: Command " + name + " :" + incorrectNumArgsMsg);
			else
				return this;
		}
		return null;
	}

	public String helpText() {
		return details + " : " + help + "\n";
	}

	public void incorrectArg() {
		System.out.println(incorrectArgsMsg);
	}
}
