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
@Table(name = "expense")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expenseid")
    private Long id;

    @Column(name = "userid")
    private Long userId;

    @Column(name = "amount")
    private double amount;

    @Column(name = "expensename")
    private String expenseName;

    @Column(name = "expenseinvoice")
    private String expenseInvoice;


    @Column(name = "type")
    private String expenseType;

    @Column(name = "mode")
    private String mode;

    @Column(name = "comment")
    private String comment;

    @Column(name = "currency")
    private String currency;

    @Column(name = "ishouseexpense")
    private Boolean isHouseExpense;

    @Column(name = "isdeleted")
    private Boolean isDeleted;

    @Column(name = "expensedate")
    private Date expenseDate;

    @Column(name = "createdby")
    private Long createdBy;

    @Column(name = "updatedby")
    private Long updatedBy;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subcategoryid")
    private ExpenseSubCategory expenseSubCategory;

}
