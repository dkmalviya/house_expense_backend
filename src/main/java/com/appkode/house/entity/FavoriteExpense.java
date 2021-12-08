package com.appkode.house.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "favorites")
public class FavoriteExpense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favoriteid")
    private Long id;


    @Column(name = "userid")
    private Long userId;

    @Column(name = "isdailyneed")
    private Boolean isDailyNeed;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "expensesubcategoryid")
    private ExpenseSubCategory expenseSubCategory;




}
