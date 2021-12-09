package com.appkode.house.controller.secure;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {


    /*@PostMapping(value = "/getMyDashboardSummary")
    public ResponseEntity<List<IncomeSourceResponse>> getMyDashboardSummary(@RequestBody @Valid DashboardSummaryRequest dashboardSummaryRequest) {
        List<IncomeSourceResponse> allIncomeSource = dasboarSummary.findAllIncomeSource();

        return new ResponseEntity<>(allIncomeSource, HttpStatus.OK);

    }*/
}
