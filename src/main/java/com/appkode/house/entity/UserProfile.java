package com.appkode.house.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_profile")
@Getter
@Setter
@NoArgsConstructor
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userprofileid")
    private Long profileId;

    @Column(name = "email")
    private String email;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "middlename")
    private String middleName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "dateofbirth")
    private Date dateOfBirth;

    @Column(name = "maritalstatus")
    private String maritalStatus;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "imageurl")
    private String imageUrl;

    @Column(name = "isnotificationenable")
    private boolean notificationEnable;

    @Column(name = "isactiveprofile")
    private boolean activeProfile;

    @Column(name = "createdon", insertable = false)
    @Type(type = "timestamp")
    private Date createdOn;


    @Column(name = "updatedon", insertable = false)
    @Type(type = "timestamp")
    private Date updatedOn;


}