package scaler.splitwise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import scaler.splitwise.models.User;

public interface UserRepository extends JpaRepository<User, Long> { }
