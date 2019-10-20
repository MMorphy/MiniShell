package hr.proging.shell.command;

import java.io.File;

import hr.proging.shell.entity.NoteDB;

public class Rm extends CommandBase {

	public Rm(String commandName, String commandDescription, String usage) {
		super(commandName, commandDescription, usage);
	}

	@Override
	public Object execute(String[] args) {
		if (args.length < 1) {
			System.out.println("Invalid arguments");
			return null;
		}
		try {
			if (args[0].contains(":\\")) {
				if (new File(args[0]).delete() != true) {
					System.out.println("Cannot delete file!");
					return null;
				} else {
					NoteDB.deleteNoteForFile(new File(args[0]));
				}
			} else {
				if (new File(CommandBase.getCurrentDir() + "\\" + args[0]).delete() != true) {
					System.out.println("Cannot delete file!");
					return null;
				} else {
					NoteDB.deleteNoteForFile(new File(CommandBase.getCurrentDir() + "\\" + args[0]));
				}
			}
		} catch (Exception e) {
			return null;
		}
		System.out.println("Success!");
		return null;
	}

}
