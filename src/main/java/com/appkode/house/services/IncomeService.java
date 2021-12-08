package com.appkode.house.services;

import com.appkode.house.model.request.income.IncomeRequest;
import com.appkode.house.model.request.generic.SearchByDateRequest;
import com.appkode.house.model.response.income.IncomeResponse;

import java.util.List;

public interface IncomeService {

    List<IncomeResponse> findAllMyIncome();
    Double getTotalIncomeByMonth(SearchByDateRequest searchByDateRequest);
    List<IncomeResponse> findAllMyIncomeByMonth(SearchByDateRequest searchByDateRequest);
    IncomeResponse addIncome(IncomeRequest incomeRequest);

    boolean deleteIncome(Long incomeId);


}
