package com.appkode.house.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "income_source")
public class IncomeSource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "incomesourceid")
    private Long id;

    @Column(name = "incomesourcename")
    private String incomeSourceName;

    @Column(name = "createdby")
    private Long createdBy;

    @Column(name = "updatedby")
    private Long updatedBy;


}
