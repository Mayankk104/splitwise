package scaler.splitwise.commands;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CommandExecutor {
    private final List<Command> commands = new ArrayList<>();

    public void addCommands(List<Command> commands) {
        this.commands.addAll(commands);
    }

    public void execute(String input) {
        boolean validCommand = false;

        for (Command command : commands) {
            if (command.matches(input)) {
                command.execute(input);
                validCommand = true;
                break;
            }
        }

        if(!validCommand) System.out.println("Invalid Command");
    }
}
