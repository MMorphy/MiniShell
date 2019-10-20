package hr.proging.shell.entity;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Note implements Serializable {

	private List<File> linkedDirs;
	String note;

	public boolean isNoteAFile() {
		try {
			File file = new File(note);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public Note() {
		this.linkedDirs = new ArrayList<File>();
	}

	public List<File> getLinkedDirs() {
		return linkedDirs;
	}

	public void setLinkedDirs(List<File> linkedDirs) {
		this.linkedDirs = linkedDirs;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void addLinkedDir(File linkedDir) {
		this.linkedDirs.add(linkedDir);
	}

	public void removeLinkedDir(File linkedDir) {
		this.linkedDirs.remove(linkedDir);
	}
}
