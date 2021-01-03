package org.ucm.tp1.p2.control.commands;

import org.ucm.tp1.p2.logic.Game;

public class AddCommand extends Command {
	private int x;
	private int y;

	public AddCommand(int x, int y, String name, String shortCut, String details, String help) {
		super(name, shortCut, details, help);
		this.x = x;
		this.y = y;
	}

	public boolean execute(Game g) {
		if (g.addSlayer(this.x, this.y)) {
			g.update();
			return true;
		}
		return false;
	}

	public Command parse(String[] tokens) throws CommandParseException {
		Command command = null;
		if (commandWords[0].equalsIgnoreCase(name) || ...) {
			if (commandWords.length != 3) throw new CommandParseException("[ERROR]: " + ...);
		
				else {
					int x; int y;
					try {
						x = Integer.parseInt(commandWords[1]);
						y = Integer.parseInt(commandWords[2]);
					}
					catch(NumberFormatException exception) {
						throw new CommandParseException("[ERROR]: " + ...);
					}
					command = new AddCommand(x, y);
				}
		}
		return command;
		}
