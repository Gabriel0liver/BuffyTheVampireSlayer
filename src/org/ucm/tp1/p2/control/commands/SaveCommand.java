package org.ucm.tp1.p2.control.commands;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.ucm.tp1.p2.logic.Game;
import org.ucm.tp1.p3.exception.CommandExecuteException;
import org.ucm.tp1.p3.exception.CommandParseException;

public class SaveCommand extends Command{
	
	protected String filename;

	public SaveCommand(String name, String shortCut, String details, String help, String filename) {
		super(name, shortCut, details, help);
		this.filename = filename+".dat";
	}

	public boolean execute(Game game) throws CommandExecuteException {
		try(BufferedWriter outStream= new BufferedWriter(new FileWriter(this.filename))) {
			outStream.write("BuffytheVampireSlayer v3.0");
			outStream.newLine();
			game.store(outStream);
			System.out.println("Game successfully saved in file "+this.filename);
			return false;
		}catch (IOException ioe) {
			throw new CommandExecuteException("[ERROR]: " + ioe.getMessage());
		}
	}

	public Command parse(String[] tokens) throws CommandParseException {
		Command command = null;
		if (tokens[0].equalsIgnoreCase("SAVE") || tokens[0].equalsIgnoreCase("S")) {
			
			if (tokens.length == 1) 
				throw new CommandParseException("[ERROR]: " + "Save must be followed by a filename");
			if (tokens.length != 2)
				throw new CommandParseException("[ERROR]: " + "Invalid filename: the filename must contain spaces");
				
			command = new SaveCommand("save","s","details","help",tokens[1]);
			return command;
		}
		return command;
	}

}
