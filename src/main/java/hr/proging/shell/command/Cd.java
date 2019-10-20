package hr.proging.shell.command;

import java.io.File;

public class Cd extends CommandBase {

	public Cd(String commandName, String commandDescription, String usage) {
		super(commandName, commandDescription, usage);
	}

	@Override
	public Object execute(String[] args) {
		File dirToGoTo = new File(CommandBase.getCurrentDir());
		// System.out.println(CommandBase.getCurrentDir());
		try {
			if (args[0].equals("..")) {
				CommandBase.setCurrentDir(dirToGoTo.getParent());
			} else {
				try {
					dirToGoTo = new File(args[0]);
					CommandBase.setCurrentDir(dirToGoTo.getAbsolutePath());
				} catch (Exception e) {
					try {
						dirToGoTo = new File(dirToGoTo.getAbsolutePath() + '\\' + args[0]);
						CommandBase.setCurrentDir(dirToGoTo.getAbsolutePath());
					} catch (Exception e2) {
						System.out.println("Invalid file path!");
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Invalid file name");
		}
		return null;
	}
}
