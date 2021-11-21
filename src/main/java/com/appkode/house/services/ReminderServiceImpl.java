package com.appkode.house.services;

import com.appkode.house.converter.remider.ReminderResponseConverter;
import com.appkode.house.entity.Reminder;
import com.appkode.house.entity.User;
import com.appkode.house.model.request.reminder.ReminderRequest;
import com.appkode.house.model.response.reminder.ReminderResponse;
import com.appkode.house.repository.ReminderRepository;
import com.appkode.house.utils.UtilFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ReminderServiceImpl implements ReminderService{

    private final ReminderResponseConverter reminderResponseConverter;
    private final ReminderRepository reminderRepository;
    private final UserProfileService userProfileService;

    @Autowired
    public ReminderServiceImpl(ReminderResponseConverter reminderResponseConverter, ReminderRepository reminderRepository, UserProfileService userProfileService) {
        this.reminderResponseConverter = reminderResponseConverter;
        this.reminderRepository = reminderRepository;
        this.userProfileService = userProfileService;
    }


    @Override
    public List<ReminderResponse> getAllReminder() {

        User user = userProfileService.getUser();
        List<Reminder> allReminders = reminderRepository.findAllByUserIdOrderByReminderDateAsc(user.getId());
        List<ReminderResponse> reminderResponseList = reminderResponseConverter.apply(allReminders);
        return reminderResponseList;

    }

    @Override
    public Boolean addReminder(ReminderRequest reminderRequest) {
        Reminder reminder = new Reminder();
        User user = userProfileService.getUser();
        reminder.setReminderName(reminderRequest.getReminderName());
        reminder.setReminderType(reminderRequest.getReminderType());
        reminder.setReminderOccurrence(reminderRequest.getReminderOccurrence());
        reminder.setUserId(user.getId());
        reminder.setNotificationEnable(reminderRequest.isNotificationEnable());
        reminder.setReminderDate(UtilFunction.dateFromString(reminderRequest.getReminderDate()));
        reminder.setCreatedBy(user.getId());
        reminder.setUpdatedBy(user.getId());
        final Reminder reminderResult = reminderRepository.save(reminder);
        return !Objects.isNull(reminderResult);
    }

    @Override
    public Boolean updateReminder(ReminderRequest reminderRequest) {
        User user = userProfileService.getUser();
        Reminder reminder = reminderRepository.findAllByIdAndUserId( reminderRequest.getReminderId(),user.getId());
        reminder.setReminderName(reminderRequest.getReminderName());
        reminder.setReminderType(reminderRequest.getReminderType());
        reminder.setReminderOccurrence(reminderRequest.getReminderOccurrence());
        reminder.setUserId(user.getId());
        reminder.setNotificationEnable(reminderRequest.isNotificationEnable());
        reminder.setReminderDate(UtilFunction.dateFromString(reminderRequest.getReminderDate()));
        reminder.setUpdatedBy(user.getId());

        final Reminder reminderResult = reminderRepository.save(reminder);
        return !Objects.isNull(reminderResult);
    }

    @Override
    public Boolean removeReminder(Long reminderId) {
        User user = userProfileService.getUser();
        Reminder reminder = reminderRepository.findAllByIdAndUserId(reminderId,user.getId());
        if(Objects.isNull(reminder)){
            return false;
        }
        reminderRepository.delete(reminder);
        return true;
    }
}
