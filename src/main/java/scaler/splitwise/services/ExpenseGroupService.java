package scaler.splitwise.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import scaler.splitwise.DTOs.ExpenseGroupRequest;
import scaler.splitwise.models.ExpenseGroup;
import scaler.splitwise.models.User;
import scaler.splitwise.repositories.ExpenseGroupRepository;

@Service
@AllArgsConstructor
public class ExpenseGroupService {

    private UserService userService;
    private ExpenseGroupRepository expenseGroupRepository;

    public ExpenseGroup insertExpenseGroup(ExpenseGroupRequest request) {

        try{
            List<User> users = userService.findAllUsersByIDs(request.getMembers());
    
            if (users.size() != request.getMembers().size())
                throw new RuntimeException("some user ids are not present in DB");
    
            ExpenseGroup expenseGroup = ExpenseGroup.builder()
                    .name(request.getName())
                    .members(users)
                    .admins(users)
                    .build();
    
            return expenseGroupRepository.save(expenseGroup);
        } catch(Exception exception) {
            System.out.println("-------------------------------------");
            System.out.println(exception.getMessage());
            System.out.println("-------------------------------------");
            return null;
        }

    }
}
