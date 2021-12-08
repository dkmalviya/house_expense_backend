package com.appkode.house.controller.secure;


import com.appkode.house.model.request.dashboard.DashboardSummaryRequest;
import com.appkode.house.model.response.income_source.IncomeSourceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {


    /*@PostMapping(value = "/getMyDashboardSummary")
    public ResponseEntity<List<IncomeSourceResponse>> getMyDashboardSummary(@RequestBody @Valid DashboardSummaryRequest dashboardSummaryRequest) {
        List<IncomeSourceResponse> allIncomeSource = dasboarSummary.findAllIncomeSource();

        return new ResponseEntity<>(allIncomeSource, HttpStatus.OK);

    }*/
}
