package hr.proging.shell.command;

import hr.proging.shell.main.CommandParser;

public class Man extends CommandBase {

	public Man(String commandName, String commandDescription, String usage) {
		super(commandName, commandDescription, usage);
	}

	@Override
	public Object execute(String[] args) {
		for (CommandBase com : CommandParser.getCommands()) {
			if (com.getCommandName().equals(args[0])) {
				System.out.println(com.getCommandDescription());
				return null;
			}
		}
		System.out.println("Unknown command!");
		return null;
	}

}
