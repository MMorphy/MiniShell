package hr.proging.shell.main;

import java.util.Scanner;

import hr.proging.shell.entity.NoteDB;

public class MiniShell {

	public static void main(String[] args) {

		boolean flag = true;
		NoteDB.loadNotes();
		Scanner input = new Scanner(System.in);
		String currentInput;
		CommandParser parser = new CommandParser();
		while (flag) {
			System.out.print("> ");
			currentInput = input.nextLine();
			if (currentInput.equalsIgnoreCase("exit")) {
				flag = false;
				input.close();
				NoteDB.persistNotes();
				return;

			} else if (currentInput.equals("")) {
				continue;
			}
			parser.parse(currentInput);
		}
	}
}
