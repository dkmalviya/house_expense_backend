package com.appkode.house.model.dto.expense;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ExpenseSubCategoryDto {
    private Long expenseSubCategoryId;
    private String expenseSubCategoryName;
    private String description;
}
