package com.appkode.house.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "expense_sub_category")
public class ExpenseSubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expensesubcategoryid")
    private Long id;

    @Column(name = "subcategoryname")
    private String expenseSubCategoryName;

    @ManyToOne
    @JoinColumn(name = "categoryid")
    ExpenseCategory expenseCategory;

    @Column(name = "description")
    private String description;

    @Column(name = "createdby")
    private Long createdBy;

    @Column(name = "updatedby")
    private Long updatedBy;



}
