package hr.proging.shell.command;

import hr.proging.shell.entity.NoteDB;

public class RmNote extends CommandBase {

	public RmNote(String commandName, String commandDescription, String usage) {
		super(commandName, commandDescription, usage);
	}

	@Override
	public Object execute(String[] args) {
		if (args.length < 1) {
			System.out.println("Invalid addn command!");
			return null;
		}
		NoteDB.remoteNote(NoteDB.findNoteByNote(args[0]));
		System.out.println("Successful note removal!");
		return null;
	}
}
