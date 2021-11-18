package com.appkode.house.model.response.expense_category;

import lombok.Data;

@Data
public class ExpenseSubCategoryDetailsResponse {

    private Long expenseSubCategoryId;
    private String expenseSubCategoryName;
    private String description;
    private Long expenseCategoryId;
    private String expenseCategoryName;

}
