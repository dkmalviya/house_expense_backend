package com.appkode.house.model.response.income;


import com.appkode.house.model.response.income_source.IncomeSourceResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IncomeResponse {

    private Long id;
    private double amount;
    private String mode;
    private String comment;
    private Date creditDate;
    private Boolean isConsiderAsHouseIncome;
    private IncomeSourceResponse incomeSourceResponse;


}
