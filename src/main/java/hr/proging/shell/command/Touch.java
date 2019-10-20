package hr.proging.shell.command;

import java.io.File;

public class Touch extends CommandBase {

	public Touch(String commandName, String commandDescription, String usage) {
		super(commandName, commandDescription, usage);
	}

	@Override
	public Object execute(String[] args) {
		try {
			if (args[0].contains(":\\")) {
				if (new File(args[0]).createNewFile() != true) {
					System.out.println("Cannot create file!");
				}
			} else {
				if (new File(CommandBase.getCurrentDir() + "\\" + args[0]).createNewFile() != true) {
					System.out.println("Cannot create file!");
				}
			}
		} catch (Exception e) {
			return null;
		}
		System.out.println("Success!");
		return null;
	}

}
