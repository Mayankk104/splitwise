package scaler.splitwise.controllers;

import org.springframework.stereotype.Controller;

import lombok.AllArgsConstructor;
import scaler.splitwise.DTOs.CreateUserRequest;
import scaler.splitwise.models.User;
import scaler.splitwise.services.UserService;

@Controller
@AllArgsConstructor
public class UserController {
    private UserService userService;
    
    public User registerUser(CreateUserRequest request) {
        return userService.createUser(request);
    }
}
