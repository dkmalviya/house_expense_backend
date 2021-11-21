package com.appkode.house.model.request.task;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class TaskRequest {

    @NotBlank
    @Size(min = 3, max = 52)
    private String taskName;

    private Long taskId;

    @NotBlank
    private String taskDate;

    @NotBlank
    private int priority;

    @NotBlank
    private boolean isCompleted;

}
