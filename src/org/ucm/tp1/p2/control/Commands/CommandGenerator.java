package org.ucm.tp1.p1.control.commands;

public class CommandGenerator {
	private static Command[] availableCommands= {
			new HelpCommand("","","",""),
			new ExitCommand("","","",""),
			new NextCommand("","","",""),
			new ResetCommand("","","",""),
			new AddCommand(0,0,"","","","")
	};
	
	public static Command parseCommand(String[] tokens) {
		Command cm = null;
		for(Command c:availableCommands) {
			cm = c.parse(tokens);
			if (cm!=null) break;
		}
		return cm;
	}
}