package com.appkode.house.model.request.expense;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Data
@ToString
public class ExpenseRequest {

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9\\s]+$")
    @Size(min = 2, max = 50)
    private String expenseName;

    private String expenseInvoice;

    @NotBlank
    @Pattern(regexp = "^[0-9\\s]+$")
    @Size(min = 1, max = 10)
    private double amount;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9\\s]+$")
    @Size(min = 2, max = 100)
    private String comment;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9\\s]+$")
    @Size(min = 2, max = 50)
    private String expenseType;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z\\s]+$")
    @Size(min = 2, max = 50)
    private String mode;

    private Boolean isHouseExpense;

    private String expenseDate;

    @NotBlank
    @Pattern(regexp = "^[0-9\\s]+$")
    @Size(min = 1, max = 10)
    private Long expenseSubCategoryId;
}
