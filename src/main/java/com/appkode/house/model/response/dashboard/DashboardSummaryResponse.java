package com.appkode.house.model.response.dashboard;

import com.appkode.house.model.dto.transaction.RecentTransactionDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DashboardSummaryResponse {
    private String month;
    private String currencyType;
    private Double currentBalance;
    private Double personalIncome;
    private Double personalSaving;
    private Double personalExpense;
    private Double houseExpense;
    private List<RecentTransactionDto> recentTransactionDto;

}
