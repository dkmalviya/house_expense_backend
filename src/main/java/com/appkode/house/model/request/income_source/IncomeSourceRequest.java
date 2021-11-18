package com.appkode.house.model.request.income_source;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class IncomeSourceRequest {

    @NotBlank
    @Size(min = 3, max = 52)
    private String  incomeSourceName;
}
