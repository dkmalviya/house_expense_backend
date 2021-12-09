package com.appkode.house.services;

import com.appkode.house.model.request.task.TaskRequest;
import com.appkode.house.model.response.task.TaskResponse;

import java.util.List;

public interface TaskService {

    List<TaskResponse> findAllTask();

    public List<TaskResponse> findAllCompetedTask();

    public List<TaskResponse> findAllPendingTask();

    public Boolean addTask(TaskRequest taskRequest);

    public List<TaskResponse> updateTaskStatus(List<TaskRequest> taskRequests);

    public Boolean removeTask(Long taskId);

}
