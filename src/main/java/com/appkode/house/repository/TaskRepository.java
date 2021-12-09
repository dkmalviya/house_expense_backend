package com.appkode.house.repository;

import com.appkode.house.entity.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> findAllByUserId(Long userId);

    Task findByIdAndUserId(Long id, Long userId);

    List<Task> findAllByUserIdAndIsCompleted(Long id, Boolean status);


}
