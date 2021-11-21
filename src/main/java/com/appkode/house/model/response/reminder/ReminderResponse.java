package com.appkode.house.model.response.reminder;


import lombok.Data;

@Data
public class ReminderResponse {

    private Long reminderId;
    private String reminderName;
    private String reminderType;
    private String reminderDate;
    private String reminderOccurrence;
    private boolean isNotificationEnable;

}
