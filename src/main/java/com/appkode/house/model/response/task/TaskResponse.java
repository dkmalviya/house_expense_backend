package com.appkode.house.model.response.task;

import lombok.Data;

@Data
public class TaskResponse {

    private Long id;
    private String taskName;
    private String taskDate;
    private int priority;
    private boolean isCompleted;
}
