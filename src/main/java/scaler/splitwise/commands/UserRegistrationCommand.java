package scaler.splitwise.commands;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import scaler.splitwise.DTOs.CreateUserRequest;
import scaler.splitwise.controllers.UserController;
import scaler.splitwise.models.User;

import java.util.List;

@Component
@AllArgsConstructor
public class UserRegistrationCommand implements Command {
    private UserController userController;

    @Override
    public boolean matches(String input) {
        return Command.getTokens(input).get(0).equals(CommandList.REGISTER_USER_COMMAND);
    }

    @Override
    public void execute(String input) {
        List<String> tokens = Command.getTokens(input);

        CreateUserRequest request = CreateUserRequest.builder()
                .name(tokens.get(1))
                .email(tokens.get(2))
                .password(tokens.get(3))
                .build();
        User savedUser = userController.registerUser(request);

        System.out.println("User created: " + "id " + savedUser.getId());
    }
}
