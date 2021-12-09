package com.appkode.house.converter.income;


import com.appkode.house.entity.Income;
import com.appkode.house.model.response.income.IncomeResponse;
import com.appkode.house.model.response.income_source.IncomeSourceResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class IncomeResponseConverter implements Function<Income, IncomeResponse> {

    @Override
    public IncomeResponse apply(Income income) {
        IncomeResponse incomeResponse = new IncomeResponse();
        incomeResponse.setAmount(income.getAmount());
        incomeResponse.setComment(income.getComment());
        incomeResponse.setCreditDate(income.getCreditDate());
        incomeResponse.setIsConsiderAsHouseIncome(income.getIsConsiderAsHouseIncome());
        incomeResponse.setId(income.getId());
        incomeResponse.setMode(income.getMode());
        incomeResponse.setIncomeSourceResponse(new IncomeSourceResponse(income.getIncomeSource().getId(), income.getIncomeSource().getIncomeSourceName()));
        return incomeResponse;
    }
}