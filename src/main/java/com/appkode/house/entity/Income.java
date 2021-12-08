package com.appkode.house.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "income")
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "incomeid")
    private Long id;

    @Column(name = "userid")
    private Long userId;

    @Column(name = "amount")
    private double amount;

    @Column(name = "mode")
    private String mode;

    @Column(name = "comments")
    private String comment;

    @Column(name = "creditdate")
    private Date creditDate;

    @Column(name = "isconsiderashouseincome")
    private Boolean isConsiderAsHouseIncome;

    @Column(name = "createdby")
    private Long createdBy;

    @Column(name = "updatedby")
    private Long updatedBy;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "incomesourceid")
    private IncomeSource incomeSource;

}
