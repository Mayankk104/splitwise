package scaler.splitwise.services;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import scaler.splitwise.DTOs.CreateUserRequest;
import scaler.splitwise.models.User;
import scaler.splitwise.repositories.UserRepository;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    
    public User createUser(CreateUserRequest request) {
        String hashedPassword = passwordEncoder.encode(request.getPassword());

        User user = User.builder()
            .name(request.getName())
            .email(request.getEmail())
            .password(hashedPassword).build();

        return userRepository.save(user);
    }
}
