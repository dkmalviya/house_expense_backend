package com.appkode.house.model.response.expense;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseResponse {

    private Long id;

    private double amount;

    private String expenseName;

    private String expenseType;

    private String mode;

    private String currency;

    private Boolean isHouseExpense;

    private Date expenseDate;

    private String createdBy;

    private Long createdById;

    private String expenseSubCategoryName;

    private String expenseCategoryName;


}
