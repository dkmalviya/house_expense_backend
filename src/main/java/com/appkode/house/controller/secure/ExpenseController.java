package com.appkode.house.controller.secure;


import com.appkode.house.model.request.expense.ExpenseRequest;
import com.appkode.house.model.request.generic.SearchByDateRequest;
import com.appkode.house.model.request.income.IncomeRequest;
import com.appkode.house.model.response.expense.ExpenseResponse;
import com.appkode.house.model.response.generic.GenericResponse;
import com.appkode.house.model.response.income.IncomeResponse;
import com.appkode.house.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping(value = "/getAllExpense")
    public ResponseEntity<List<ExpenseResponse>> getAllExpense(@RequestBody SearchByDateRequest searchByDateRequest) {
        //List<ExpenseResponse> allExpense = expenseService.findAllMyExpenseByMonth(searchByDateRequest);
        List<ExpenseResponse> allExpense = expenseService.findAllHouseExpenseByMonth(searchByDateRequest);
        return new ResponseEntity<>(allExpense, HttpStatus.OK);

    }

    @PostMapping(value = "/getAllExpenseOfHouse")
    public ResponseEntity<List<ExpenseResponse>> getAllExpenseOfHouse(@RequestBody SearchByDateRequest searchByDateRequest) {
        List<ExpenseResponse> allExpense = expenseService.findAllHouseExpenseByMonth(searchByDateRequest);
        return new ResponseEntity<>(allExpense, HttpStatus.OK);

    }


    @PostMapping(value = "/addExpense")
    public ResponseEntity<ExpenseResponse> addExpense(@RequestBody ExpenseRequest expenseRequest) {
        ExpenseResponse expenseResponse = expenseService.addExpense(expenseRequest);

        return new ResponseEntity<>(expenseResponse, HttpStatus.OK);

    }

    @PutMapping(value = "/deleteIncome/{id}")
    public ResponseEntity<GenericResponse> addIncome(@PathVariable Long expenseId) {
        Boolean result = expenseService.deleteExpense(expenseId);
        return new ResponseEntity<>(new GenericResponse(0, "Success", "Expense deleted successfully"), HttpStatus.OK);
    }
}
