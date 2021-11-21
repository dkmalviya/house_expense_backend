package com.appkode.house.model.request.reminder;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class ReminderRequest {

    private Long reminderId;

    @NotBlank
    @Size(min = 3, max = 52)
    private String reminderType;

    @NotBlank
    @Size(min = 3, max = 52)
    private String reminderName;

    private String reminderDate;

    @NotBlank
    private String reminderOccurrence;

    @NotBlank
    private boolean isNotificationEnable;

}
