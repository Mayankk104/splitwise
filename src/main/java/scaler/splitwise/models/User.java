package scaler.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"), name = "users")
@Builder
public class User extends BaseModel {
    private String name;
    private String email;
    private String password;
}
