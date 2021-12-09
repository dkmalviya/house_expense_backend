package com.appkode.house.controller.secure;


import com.appkode.house.model.request.reminder.ReminderRequest;
import com.appkode.house.model.response.generic.GenericResponse;
import com.appkode.house.model.response.reminder.ReminderResponse;
import com.appkode.house.services.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reminder")
public class ReminderController {
    private final ReminderService reminderService;


    @Autowired
    public ReminderController(ReminderService reminderService) {
        this.reminderService = reminderService;
    }


    @GetMapping(value = "/getAllReminder")
    public ResponseEntity<List<ReminderResponse>> getAllReminder() {
        List<ReminderResponse> reminderResponseList = reminderService.getAllReminder();
        return new ResponseEntity<>(reminderResponseList, HttpStatus.OK);
    }

    @PostMapping(value = "/addReminder")
    public ResponseEntity<GenericResponse> addReminder(@RequestBody ReminderRequest reminderRequest) {
        Boolean result = reminderService.addReminder(reminderRequest);
        if (result) {
            return new ResponseEntity<>(new GenericResponse(0, "Success", "Reminder added successfully."), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new GenericResponse(99, "Failed", "Unable to add Reminder."), HttpStatus.OK);

        }
    }

    @PostMapping(value = "/updateReminder")
    public ResponseEntity<GenericResponse> updateReminder(@RequestBody ReminderRequest reminderRequest) {
        Boolean result = reminderService.updateReminder(reminderRequest);
        if (result) {
            return new ResponseEntity<>(new GenericResponse(0, "Success", "Reminder updated successfully."), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new GenericResponse(99, "Failed", "Unable to update Reminder."), HttpStatus.OK);
        }
    }

    @DeleteMapping(value = "/removeReminder/{reminderId}")
    public ResponseEntity<GenericResponse> removeReminder(@PathVariable Long reminderId) {
        Boolean result = reminderService.removeReminder(reminderId);
        if (result) {
            return new ResponseEntity<>(new GenericResponse(0, "Success", "Reminder deleted successfully."), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new GenericResponse(99, "Failed", "Unable to delete Reminder."), HttpStatus.OK);

        }
    }


}
