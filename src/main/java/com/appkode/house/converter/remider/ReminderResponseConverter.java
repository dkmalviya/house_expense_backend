package com.appkode.house.converter.remider;

import com.appkode.house.entity.Reminder;
import com.appkode.house.model.response.reminder.ReminderResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Component
public class ReminderResponseConverter implements Function<List<Reminder>, List<ReminderResponse>> {
    @Override
    public List<ReminderResponse> apply(List<Reminder> reminders) {
        List<ReminderResponse> reminderResponseList= new ArrayList<>();
        for (Reminder reminder : reminders) {
            ReminderResponse reminderResponse = new ReminderResponse();
            reminderResponse.setReminderId(reminder.getId());
            reminderResponse.setReminderType(reminder.getReminderType());
            reminderResponse.setReminderDate(reminder.getReminderDate().toString());
            reminderResponse.setReminderName(reminder.getReminderName());
            reminderResponse.setReminderOccurrence(reminder.getReminderOccurrence());
            reminderResponse.setNotificationEnable(reminder.isNotificationEnable());
            reminderResponseList.add(reminderResponse);
        }

        return reminderResponseList;
    }
}
