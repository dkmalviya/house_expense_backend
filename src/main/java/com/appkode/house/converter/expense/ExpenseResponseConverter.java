package com.appkode.house.converter.expense;


import com.appkode.house.entity.Expense;
import com.appkode.house.model.response.expense.ExpenseResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ExpenseResponseConverter implements Function<Expense, ExpenseResponse> {

    @Override
    public ExpenseResponse apply(Expense expense) {
        ExpenseResponse expenseResponse = new ExpenseResponse();
        expenseResponse.setId(expense.getId());
        expenseResponse.setExpenseDate(expense.getExpenseDate());
        expenseResponse.setExpenseName(expense.getExpenseName());
        expenseResponse.setExpenseType(expense.getExpenseType());
        expenseResponse.setAmount(expense.getAmount());
        expenseResponse.setMode(expense.getMode());
        expenseResponse.setIsHouseExpense(expense.getIsHouseExpense());
        expenseResponse.setCreatedBy("TODO");
        expenseResponse.setCreatedById(0L);
        expenseResponse.setCurrency(expense.getCurrency());
        expenseResponse.setExpenseCategoryName(expense.getExpenseSubCategory().getExpenseCategory().getExpenseCategoryName());
        expenseResponse.setExpenseSubCategoryName(expense.getExpenseSubCategory().getExpenseSubCategoryName());
        return expenseResponse;

    }


}
