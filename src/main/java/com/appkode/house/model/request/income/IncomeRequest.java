package com.appkode.house.model.request.income;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class IncomeRequest {

    @NotBlank
    @Pattern(regexp = "^[0-9\\s]+$")
    @Size(min = 1, max = 10)
    private double amount;


    @NotBlank
    @Pattern(regexp = "^[a-zA-Z\\s]+$")
    @Size(min = 2, max = 50)
    private String mode;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9\\s]+$")
    @Size(min = 2, max = 100)
    private String comment;

    private String creditDate;

    private Boolean isConsiderAsHouseIncome;

    @NotBlank
    @Pattern(regexp = "^[0-9\\s]+$")
    @Size(min = 1, max = 10)
    private Long incomeSourceId;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9\\s]+$")
    @Size(min = 2, max = 100)
    private String incomeSourceName;


}
