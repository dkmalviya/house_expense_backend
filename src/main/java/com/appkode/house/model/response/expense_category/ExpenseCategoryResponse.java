package com.appkode.house.model.response.expense_category;

import lombok.Data;

@Data
public class ExpenseCategoryResponse {

    private Long expenseCategoryId;
    private String expenseCategoryName;
    private String description;
}
