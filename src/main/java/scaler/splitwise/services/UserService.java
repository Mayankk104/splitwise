package scaler.splitwise.services;

import java.util.ArrayList;
import java.util.List;

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

        if (user == null)
            return null;

        return userRepository.save(user);
    }
    
    public List<User> findAllUsersByIDs(List<Long> Ids) {
        List<User> users = new ArrayList<>();

        if (Ids == null || Ids.isEmpty())
            return users;

        return userRepository.findAllById(Ids);
    }
}
