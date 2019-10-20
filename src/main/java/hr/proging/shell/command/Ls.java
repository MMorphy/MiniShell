package hr.proging.shell.command;

import java.io.File;

import hr.proging.shell.entity.NoteDB;

public class Ls extends CommandBase {

	public Ls(String commandName, String commandDescription, String usage) {
		super(commandName, commandDescription, usage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object execute(String[] args) {
		File currentDirectory;
		if (args == null) {
			currentDirectory = new File(CommandBase.getCurrentDir());
		} else {
			try {
				currentDirectory = new File(args[0]);
			} catch (Exception ex) {
				System.out.println("Invalid argument!");
				return null;
			}
		}
		for (String file : currentDirectory.list()) {
			System.out.println(file + " " + NoteDB.findNoteForFile(new File(currentDirectory + "\\" + file)));
		}
		return null;
	}
}
