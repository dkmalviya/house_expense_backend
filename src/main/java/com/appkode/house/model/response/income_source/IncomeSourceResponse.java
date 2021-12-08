package com.appkode.house.model.response.income_source;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.A;

@Data

@NoArgsConstructor
@AllArgsConstructor
public class IncomeSourceResponse {

    private Long incomeSourceId;
    private String incomeSourceName;
}
