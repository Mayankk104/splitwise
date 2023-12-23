package scaler.splitwise.DTOs;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateUserRequest {
    private String name;
    private String password;
    private String email;
}
