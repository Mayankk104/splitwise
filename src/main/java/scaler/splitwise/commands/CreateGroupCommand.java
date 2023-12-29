package scaler.splitwise.commands;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import scaler.splitwise.DTOs.ExpenseGroupRequest;
import scaler.splitwise.controllers.ExpenseGroupController;
import scaler.splitwise.models.ExpenseGroup;

import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class CreateGroupCommand implements Command{
    private ExpenseGroupController expenseGroupController;

    @Override
    public boolean matches(String input) {
        String command = Command.getCommand(input);
        return command.equals(CommandList.CREATE_GROUP_COMMAND);
    }

    @Override
    public void execute(String input) {
        List<String> tokens = Command.getTokens(input);

        for(String token: tokens) System.out.println(token);

        ExpenseGroupRequest request = ExpenseGroupRequest.builder()
                .name(tokens.get(1))
                .members(
                    Arrays.stream(tokens.get(2).split(","))
                        .map(String::trim)
                        .map(Long::parseLong)
                        .toList()
                ).build();

        ExpenseGroup expenseGroup = expenseGroupController.createGroup(request);
       
        if (expenseGroup != null)
            System.out.println("Group with group id: " + expenseGroup.getId() + "created");
        else
            System.out.println("couldn't create group");
    }
}
