package hr.proging.shell.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hr.proging.shell.command.AddNote;
import hr.proging.shell.command.Cd;
import hr.proging.shell.command.CommandBase;
import hr.proging.shell.command.Ls;
import hr.proging.shell.command.Man;
import hr.proging.shell.command.Pwd;
import hr.proging.shell.command.Rm;
import hr.proging.shell.command.RmNote;
import hr.proging.shell.command.Touch;
import hr.proging.shell.command.Usage;

public class CommandParser {

	String command;
	String[] arguments;
	public static List<CommandBase> commands;

	public CommandParser() {
		CommandParser.commands = new ArrayList<>();
		CommandParser.commands.add(
				new AddNote("addn", "Adds new note to file", "addn <note, string or file> <file to add the note to>"));
		CommandParser.commands.add(new Cd("cd", "Changes working directory", "cd <path to new working directory>"));
		CommandParser.commands
				.add(new Ls("ls", "Lists files in working directory or path", "ls <path to directory to list>"));
		CommandParser.commands.add(new Pwd("pwd", "Lists the current working directory", "pwd"));
		CommandParser.commands.add(new RmNote("rmn", "Removes note from file", "rmn <file to remove the note from>"));
		CommandParser.commands.add(new Man("man", "Explains the inteded use of a command", "man <command name>"));
		CommandParser.commands.add(new Usage("usage", "Displays the usage of the command", "usage <command name>"));
		CommandParser.commands.add(new Rm("rm", "Deletes a file", "rm <file path>"));
		CommandParser.commands.add(new Touch("touch", "Creates a new file", "touch <file path>"));

	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String[] getArguments() {
		return arguments;
	}

	public void setArguments(String[] arguments) {
		this.arguments = arguments;
	}

	public static List<CommandBase> getCommands() {
		return commands;
	}

	public static void setCommands(List<CommandBase> commands) {
		CommandParser.commands = commands;
	}

	public static void addCommand(CommandBase command) {
		CommandParser.commands.add(command);
	}

	public void parse(String input) {
		boolean valid = false;
		this.arguments = getArgs(input);
		this.command = getCommand(input);
		for (CommandBase com : commands) {
			if (com.getCommandName().equals(this.command)) {
				com.execute(arguments);
				valid = true;
			}
		}
		if (!valid) {
			System.out.println("Invalid command");
		}
	}

	private String getCommand(String input) {
		String command;
		if (input.indexOf(" ") == -1) {
			return input;
		}
		command = input.substring(0, input.indexOf(" "));
		return command;
	}

	private String[] getArgs(String input) {
		String[] args;
		if (input.indexOf(" ") == -1) {
			return null;
		}
		args = input.substring(input.indexOf(" ") + 1).split(" ");
		return escapeCharacters(args);
	}

	private String[] escapeCharacters(String[] args) {
		String[] escapedArray = Arrays.copyOf(args, args.length);
		for (int i = 0; i < args.length; i++) {
			escapedArray[i] = args[i].replaceAll("\\\\", "\\\\\\\\");
		}
		return escapedArray;
	}
}
