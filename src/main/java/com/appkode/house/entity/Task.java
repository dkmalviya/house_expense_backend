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
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "taskid")
    private Long id;

    @Column(name = "taskname")
    private String taskName;

    @Column(name = "taskdate")
    private Date taskDate;

    @Column(name = "priority")
    private int priority;

    @Column(name = "iscompleted")
    private boolean isCompleted;

    @Column(name = "userid")
    private Long userId ;

    @Column(name = "createdby")
    private Long createdBy ;

    @Column(name = "updatedby")
    private Long updatedBy ;




}
