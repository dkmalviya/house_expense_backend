package com.appkode.house.model.response.expense_category;

import com.appkode.house.model.dto.expense.ExpenseSubCategoryDto;
import lombok.Data;

import java.util.List;

@Data
public class ExpenseSubCategoryResponse {

    List<ExpenseSubCategoryDto> expenseSubCategoryDtoList;
    private Long expenseCategoryId;
    private String expenseCategoryName;
    private String description;

}
