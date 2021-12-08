package com.appkode.house.controller.secure;

import com.appkode.house.model.request.income.IncomeRequest;
import com.appkode.house.model.request.generic.SearchByDateRequest;
import com.appkode.house.model.response.generic.GenericResponse;
import com.appkode.house.model.response.income.IncomeResponse;
import com.appkode.house.services.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/income")
public class IncomeController {
    private final IncomeService incomeService;

    @Autowired
    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }


    @PostMapping(value = "/getAllIncomeMonth")
    public ResponseEntity<List<IncomeResponse>> getAllIncome(@RequestBody SearchByDateRequest searchByDateRequest) {
        List<IncomeResponse> allIncome = incomeService.findAllMyIncomeByMonth(searchByDateRequest);
        return new ResponseEntity<>(allIncome, HttpStatus.OK);

    }


    @PostMapping(value = "/addIncome")
    public ResponseEntity<IncomeResponse> addIncome(@RequestBody IncomeRequest incomeRequest) {
        IncomeResponse incomeResponse = incomeService.addIncome(incomeRequest);

        return new ResponseEntity<>(incomeResponse, HttpStatus.OK);

    }

    @DeleteMapping(value = "/deleteIncome/{id}")
    public ResponseEntity<GenericResponse> addIncome(@PathVariable Long incomeId) {
        Boolean result = incomeService.deleteIncome(incomeId);
        return new ResponseEntity<>(new GenericResponse(0, "Success", "Income deleted successfully"), HttpStatus.OK);
    }
}
