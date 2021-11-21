package com.appkode.house.model.request.expense_category;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class FavoriteExpenseRequest {

    @NotBlank
    @Size(min = 1, max = 10)
    private Long  expenseSubCategoryId;

    @NotBlank
    private Boolean isDailyNeed;

}
