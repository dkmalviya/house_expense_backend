package com.appkode.house.model.request.expense_category;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class ExpenseSubCategoryRequest {

    @NotBlank
    @Size(min = 3, max = 52)
    private String expenseSubCategoryName;

    @NotBlank
    @Size(min = 2, max = 52)
    private String description;
    @NotBlank
    @Size(min = 0, max = 10)
    private Long categoryId;


}
