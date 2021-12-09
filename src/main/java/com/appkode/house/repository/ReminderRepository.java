package com.appkode.house.repository;

import com.appkode.house.entity.Reminder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReminderRepository extends CrudRepository<Reminder, Long> {
    Reminder findAllByIdAndUserId(Long reminderId, Long userId);

    List<Reminder> findAllByUserIdOrderByReminderDateAsc(Long userId);


}
