package hr.proging.shell.command;

import java.io.File;

import hr.proging.shell.entity.Note;
import hr.proging.shell.entity.NoteDB;

public class AddNote extends CommandBase {

	public AddNote(String commandName, String commandDescription, String usage) {
		super(commandName, commandDescription, usage);
	}

	@Override
	public Object execute(String[] args) {
		if (args.length < 2) {
			System.out.println("Invalid addn command!");
			return null;
		}
		Note note = NoteDB.findNoteByNote(args[0]);
		try {
			File file = null;
			for (int i = 1; i < args.length; i++) {
				if (args[i].contains(":\\")) {
					file = new File(args[i]);
				} else {
					file = new File(CommandBase.getCurrentDir() + "\\" + args[i]);
				}
				if (NoteDB.findNoteForFile(file).equals("")) {
					note.addLinkedDir(file);
				}
			}
		} catch (Exception e) {
			System.out.println("Invalid files");
			return null;
		}
		NoteDB.addNote(note);
		return null;
	}
}
