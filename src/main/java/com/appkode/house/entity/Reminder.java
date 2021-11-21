package com.appkode.house.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "reminder")
public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reminderid")
    private Long id;

    @Column(name = "remindertype")
    private String reminderType;

    @Column(name = "remindername")
    private String reminderName;

    @Column(name = "reminderdate")
    private Date reminderDate;

    @Column(name = "reminderoccurrence")
    private String  reminderOccurrence;

    @Column(name = "isnotificationenable")
    private boolean isNotificationEnable;

    @Column(name = "userid")
    private Long userId ;

    @Column(name = "createdby")
    private Long createdBy ;

    @Column(name = "updatedby")
    private Long updatedBy ;




}
