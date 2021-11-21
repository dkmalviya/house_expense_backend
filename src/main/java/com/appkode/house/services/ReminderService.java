package com.appkode.house.services;

import com.appkode.house.model.request.reminder.ReminderRequest;
import com.appkode.house.model.response.reminder.ReminderResponse;

import java.util.List;

public interface ReminderService {


    List<ReminderResponse> getAllReminder();
    Boolean addReminder(ReminderRequest reminderRequest);
    Boolean updateReminder(ReminderRequest reminderRequest);
    Boolean removeReminder(Long reminderId);
}
