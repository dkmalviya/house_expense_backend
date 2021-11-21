package com.appkode.house.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "credentials")
public class Credential {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "credentialid")
    private Long id;

    @Column(name = "accountname")
    private String accountName;

    @Column(name = "accountcategory")
    private String accountCategory;

    @Column(name = "username")
    private String userName;

    @Column(name = "primarypassword")
    private String primaryPassword;

    @Column(name = "secondarypassword")
    private String secondaryPassword;

    @Column(name = "pin")
    private String pin;

    @Column(name = "recoveryemail")
    private String recoveryEmail;

    @Column(name = "userid")
    private Long userId;

    @Column(name = "createdby")
    private Long createdBy;

    @Column(name = "updatedby")
    private Long updatedBy;


}
