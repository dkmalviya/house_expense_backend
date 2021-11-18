package com.appkode.house.model.request.expense_category;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class ExpenseCategoryRequest {

    @NotBlank
    @Size(min = 3, max = 52)
    private String  expenseCategoryName;

    @NotBlank
    @Size(min = 2, max = 52)
    private String  description;


}
