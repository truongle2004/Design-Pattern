package command;

public class CommandProcessor {
    private static CommandProcessor commandProcessor = null;

    public static CommandProcessor getInstance() {
        if (commandProcessor == null) {
            commandProcessor = new CommandProcessor();
        }
        return commandProcessor;
    }

    public void execute(Command command) {
        command.execute();
    }
}
