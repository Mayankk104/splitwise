package scaler.splitwise.controllers;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import scaler.splitwise.DTOs.ExpenseGroupRequest;
import scaler.splitwise.models.ExpenseGroup;
import scaler.splitwise.services.ExpenseGroupService;

@Controller
@AllArgsConstructor
public class ExpenseGroupController {
    private ExpenseGroupService expenseGroupService;

    public ExpenseGroup createGroup(ExpenseGroupRequest request) {
        return expenseGroupService.insertExpenseGroup(request);
    }
}
