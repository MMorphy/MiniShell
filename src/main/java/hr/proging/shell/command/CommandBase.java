package hr.proging.shell.command;

public abstract class CommandBase {
	static String currentDir;
	private String commandName;
	private String commandDescription;
	private String usage;
	
	public CommandBase(String commandName, String commandDescription, String usage) {
		this.commandName = commandName;
		this.commandDescription = commandDescription;
		this.usage = usage;
		CommandBase.currentDir = System.getProperty("user.dir");
	}

	public abstract Object execute(String[] args);

	public String getCommandName() {
		return commandName;
	}

	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}

	public String getCommandDescription() {
		return commandDescription;
	}

	public void setCommandDescription(String commandDescription) {
		this.commandDescription = commandDescription;
	}

	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	public static String getCurrentDir() {
		return currentDir;
	}

	public static void setCurrentDir(String currentDir) {
		CommandBase.currentDir = currentDir;
	}
}
