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
@Table(name = "house_member")
public class HouseMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "housememberid")
    private Long id;

    @Column(name = "userid")
    private Long userId;

    @Column(name = "isactivemember")
    private Boolean isActiveMember;

    @Column(name = "isadminofhouse")
    private Boolean isAdminOfHouse;

    @Column(name = "startdate")
    private Date startDate;

    @Column(name = "enddate")
    private Date endDate;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "currenthouseid")
    private House house;

}
