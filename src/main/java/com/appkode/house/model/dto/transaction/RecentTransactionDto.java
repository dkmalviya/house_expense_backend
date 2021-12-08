package com.appkode.house.model.dto.transaction;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class RecentTransactionDto {

    private Long transactionId;
    private String transactionType;
    private String transactionName;
    private String transactionAmount;
    private Date transactionDate;
}
