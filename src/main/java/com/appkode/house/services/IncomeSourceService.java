package com.appkode.house.services;

import com.appkode.house.model.request.income_source.IncomeSourceRequest;
import com.appkode.house.model.response.income_source.IncomeSourceResponse;

import java.util.List;

public interface IncomeSourceService {


    List<IncomeSourceResponse> findAllIncomeSource();
    IncomeSourceResponse addIncomeSource(IncomeSourceRequest incomeSourceRequest);
    Boolean isIncomeSourceExists(String name);

    boolean deleteIncomeSource(Long id);

}
