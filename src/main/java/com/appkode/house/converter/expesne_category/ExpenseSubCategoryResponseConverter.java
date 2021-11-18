package com.appkode.house.converter.expesne_category;

import com.appkode.house.entity.ExpenseCategory;
import com.appkode.house.entity.ExpenseSubCategory;
import com.appkode.house.model.dto.expense.ExpenseSubCategoryDto;
import com.appkode.house.model.response.expense_category.ExpenseCategoryResponse;
import com.appkode.house.model.response.expense_category.ExpenseSubCategoryResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ExpenseSubCategoryResponseConverter implements Function<ExpenseCategory, ExpenseSubCategoryResponse> {

    @Override
    public ExpenseSubCategoryResponse apply(ExpenseCategory expenseCategory) {
        ExpenseSubCategoryResponse expenseCategoryResponse = new ExpenseSubCategoryResponse();
        expenseCategoryResponse.setExpenseCategoryId(expenseCategory.getId());
        expenseCategoryResponse.setExpenseCategoryName(expenseCategory.getExpenseCategoryName());
        expenseCategoryResponse.setDescription(expenseCategory.getDescription());


        expenseCategoryResponse.setExpenseSubCategoryDtoList(expenseCategory.getExpenseSubCategoryList()
                .stream()
                .map(subCategory -> ExpenseSubCategoryDto
                        .builder()
                        .expenseSubCategoryId(subCategory.getId())
                        .expenseSubCategoryName(subCategory.getExpenseSubCategoryName())
                        .description(subCategory.getDescription())
                        .build())
                .collect(Collectors.toList()));
        return expenseCategoryResponse;
    }
}
