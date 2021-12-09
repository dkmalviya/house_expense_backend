package com.appkode.house.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "house")
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "houseid")
    private Long id;

    @Column(name = "housename")
    private String houseName;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressid")
    private Address address;


}
