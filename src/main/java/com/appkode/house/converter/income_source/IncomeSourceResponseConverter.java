package com.appkode.house.converter.income_source;

import com.appkode.house.entity.IncomeSource;
import com.appkode.house.model.response.income_source.IncomeSourceResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class IncomeSourceResponseConverter implements Function<IncomeSource, IncomeSourceResponse> {

    @Override
    public IncomeSourceResponse apply(IncomeSource incomeSource) {
        IncomeSourceResponse incomeSourceResponse = new IncomeSourceResponse();
        incomeSourceResponse.setIncomeSourceId(incomeSource.getId());
        incomeSourceResponse.setIncomeSourceName(incomeSource.getIncomeSourceName());
        return incomeSourceResponse;
    }
}
