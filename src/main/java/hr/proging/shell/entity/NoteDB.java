package hr.proging.shell.entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class NoteDB {

	public static List<Note> notes = new ArrayList<Note>();

	public static void addNote(Note note) {
		notes.add(note);
	}

	public static void remoteNote(Note note) {
		notes.remove(note);
	}

	public static String findNoteForFile(File file) {
		for (Note note : notes) {
			for (File dir : note.getLinkedDirs()) {
				if (dir.equals(file)) {
					return note.getNote();
				}
			}
		}
		return "";
	}

	public static Note findNoteByNote(String note) {
		for (Note nt : notes) {
			if (nt.getNote().equals(note)) {
				return nt;
			}
		}
		Note n = new Note();
		n.setNote(note);
		return n;
	}
	public static void deleteNoteForFile(File file) {
		for (Note note : notes) {
			for(File dir : note.getLinkedDirs()) {
				if(dir.equals(file)) {
					if(note.getLinkedDirs().size() < 2) {
						notes.remove(note);
					}
					else {
						note.removeLinkedDir(file);
					}
				}
			}
		}
	}

	public static void persistNotes() {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.ser"));) {
			out.writeObject(notes);
		} catch (Exception ex) {
		}
	}

	public static void loadNotes() {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.ser"));) {
			notes = (ArrayList<Note>) in.readObject();
		} catch (Exception ex) {
		}
	}
}
