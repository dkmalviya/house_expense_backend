package com.appkode.house.converter.expesne_category;

import com.appkode.house.entity.ExpenseCategory;
import com.appkode.house.model.response.expense_category.ExpenseCategoryResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ExpenseCategoryResponseConverter implements Function<ExpenseCategory, ExpenseCategoryResponse> {

    @Override
    public ExpenseCategoryResponse apply(ExpenseCategory expenseCategory) {
        ExpenseCategoryResponse expenseCategoryResponse = new ExpenseCategoryResponse();
        expenseCategoryResponse.setExpenseCategoryId(expenseCategory.getId());
        expenseCategoryResponse.setExpenseCategoryName(expenseCategory.getExpenseCategoryName());
        expenseCategoryResponse.setDescription(expenseCategory.getDescription());
        return expenseCategoryResponse;
    }
}
