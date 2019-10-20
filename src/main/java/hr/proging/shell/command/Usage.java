package hr.proging.shell.command;

import hr.proging.shell.main.CommandParser;

public class Usage extends CommandBase {

	public Usage(String commandName, String commandDescription, String usage) {
		super(commandName, commandDescription, usage);
	}

	@Override
	public Object execute(String[] args) {
		for (CommandBase com : CommandParser.getCommands()) {
			if (com.getCommandName().equals(args[0])) {
				System.out.println(com.getUsage());
				return null;
			}
		}
		System.out.println("Unknown command!");
		return null;
	}
}
