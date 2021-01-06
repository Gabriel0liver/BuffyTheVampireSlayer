package org.ucm.tp1.p2.control.commands;

import org.ucm.tp1.p3.exception.CommandParseException;

public class CommandGenerator {
	private static Command[] availableCommands= {
			new HelpCommand("","","",""),
			new ExitCommand("","","",""),
			new NextCommand("","","",""),
			new ResetCommand("","","",""),
			new AddCommand(0,0,"","","",""),
			new GarlicPushCommand("","","",""),
			new LightFlashCommand("","","",""),
			new AddBloodBank(0,0,0,"","","",""),
			new SuperCoinsCommand("","","",""),
			new AddVampireCommand(0,0,"","","","")
	};
	
	public static Command parse(String[] tokens) throws CommandParseException{
		try {
		Command cm = null;
		for(Command c:availableCommands) {
			cm = c.parse(tokens);
			if (cm!=null) break;
		}
		if(cm == null) 
			throw new CommandParseException("[ERROR]: " + "Uknown Command");
		return cm;
		}
		finally {
			
		}
		
		
	}
}
