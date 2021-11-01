package com.appkode.UserService.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
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
    @Column(name = "userProfileId")
    private Long profileId;

    @Column(name = "email")
    private String email;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "middleName")
    private String middleName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "dateOfBirth")
    private Date dateOfBirth;

    @Column(name = "maritalStatus")
    private String maritalStatus;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "imageUrl")
    private String imageUrl;

    @Column(name = "isNotificationEnable")
    private boolean notificationEnable;

    @Column(name = "isActiveProfile")
    private boolean activeProfile;

    @Column(name = "createdOn", insertable = false)
    @Type(type = "timestamp")
    private Date createdOn;


    @Column(name = "updatedOn", insertable = false)
    @Type(type = "timestamp")
    private Date updatedOn;


}