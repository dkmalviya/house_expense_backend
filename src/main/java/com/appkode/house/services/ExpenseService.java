package com.appkode.house.services;

import com.appkode.house.model.request.expense.ExpenseRequest;
import com.appkode.house.model.request.generic.SearchByDateRequest;
import com.appkode.house.model.response.expense.ExpenseResponse;

import java.util.List;

public interface ExpenseService {

    Double getTotalExpenseByMonth(SearchByDateRequest searchByDateRequest);

    List<ExpenseResponse> findAllMyExpenseByMonth(SearchByDateRequest searchByDateRequest);

    List<ExpenseResponse> findAllHouseExpenseByMonth(SearchByDateRequest searchByDateRequest);

    ExpenseResponse addExpense(ExpenseRequest expenseRequest);

    boolean deleteExpense(Long expenseId);


}
