package scaler.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Builder;

import java.util.List;

@Entity
@Builder
public class ExpenseGroup extends BaseModel{
    private String name;

    private String description;

    @ManyToMany
    private List<User> members;

    @ManyToMany
    private List<User> admins;

}
