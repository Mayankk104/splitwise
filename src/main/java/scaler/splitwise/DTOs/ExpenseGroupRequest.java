package scaler.splitwise.DTOs;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class ExpenseGroupRequest {
    private String name;
    private String description;
    private List<Long> members;
}
