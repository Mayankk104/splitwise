package scaler.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.*;

@Entity
@Getter
@Setter
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"), name = "users")
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor // TODO: chekc AllArgsContructor is required or not
public class User extends BaseModel {
    private String name;
    private String email;
    private String password;
}
