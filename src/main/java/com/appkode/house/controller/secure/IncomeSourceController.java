package com.appkode.house.controller.secure;

import com.appkode.house.model.request.income_source.IncomeSourceRequest;
import com.appkode.house.model.response.generic.GenericResponse;
import com.appkode.house.model.response.income_source.IncomeSourceResponse;
import com.appkode.house.services.IncomeSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/income/incomeSource")
public class IncomeSourceController {
    private final IncomeSourceService incomeSourceService;

    @Autowired
    public IncomeSourceController(IncomeSourceService incomeSourceService) {
        this.incomeSourceService = incomeSourceService;
    }

    @GetMapping(value = "/getAllIncomeSource")
    public ResponseEntity<List<IncomeSourceResponse>> getAllIncomeSource() {
        List<IncomeSourceResponse> allIncomeSource = incomeSourceService.findAllIncomeSource();

            return new ResponseEntity<>(allIncomeSource, HttpStatus.OK);

    }


    @PostMapping(value = "/addIncomeSource")
    public ResponseEntity<IncomeSourceResponse> getAllIncomeSource(@RequestBody IncomeSourceRequest incomeSourceRequest) {
        IncomeSourceResponse incomeSourceResponse = incomeSourceService.addIncomeSource(incomeSourceRequest);

        return new ResponseEntity<>(incomeSourceResponse, HttpStatus.OK);

    }
}
