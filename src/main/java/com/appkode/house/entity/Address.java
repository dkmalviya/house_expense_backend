package com.appkode.house.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@NoArgsConstructor
@Getter
@Setter
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addressid")
    private Long id;

    @Column(name = "housenumber")
    private String houseNumber;

    @Column(name = "buildingname")
    private String buildingName;

    @Column(name = "street")
    private String street;

    @Column(name = "area")
    private String area;

    @Column(name = "landmark")
    private String landmark;

    @Column(name = "city")
    private String city;

    @Column(name = "pincode")
    private String pinCode;


}
