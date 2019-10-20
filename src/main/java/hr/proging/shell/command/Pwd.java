package hr.proging.shell.command;

public class Pwd extends CommandBase {

	public Pwd(String commandName, String commandDescription, String usage) {
		super(commandName, commandDescription, usage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object execute(String[] args) {
		System.out.println(CommandBase.getCurrentDir());
		return null;
	}
}
