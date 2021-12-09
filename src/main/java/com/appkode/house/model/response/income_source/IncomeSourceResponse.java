package com.appkode.house.model.response.income_source;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
@AllArgsConstructor
public class IncomeSourceResponse {

    private Long incomeSourceId;
    private String incomeSourceName;
}
