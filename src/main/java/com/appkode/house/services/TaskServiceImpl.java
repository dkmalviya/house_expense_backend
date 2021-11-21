package com.appkode.house.services;

import com.appkode.house.converter.task.TaskResponseConverter;
import com.appkode.house.entity.Task;
import com.appkode.house.entity.User;
import com.appkode.house.model.request.task.TaskRequest;
import com.appkode.house.model.response.task.TaskResponse;
import com.appkode.house.repository.TaskRepository;
import com.appkode.house.utils.UtilFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class TaskServiceImpl implements TaskService {

    private final UserProfileService userProfileService;
    private final TaskRepository taskRepository;
    private final TaskResponseConverter taskResponseConverter;

    @Autowired
    public TaskServiceImpl(UserProfileService userProfileService, TaskRepository taskRepository, TaskResponseConverter taskResponseConverter) {
        this.userProfileService = userProfileService;
        this.taskRepository = taskRepository;
        this.taskResponseConverter = taskResponseConverter;
    }


    @Override
    public List<TaskResponse> findAllTask() {
        User user = userProfileService.getUser();
        List<Task> allTasks = taskRepository.findAllByUserId(user.getId());
        List<TaskResponse> taskResponseList = taskResponseConverter.apply(allTasks);
        return taskResponseList;
    }

    @Override
    public List<TaskResponse> findAllCompetedTask() {
        User user = userProfileService.getUser();
        List<Task> allTasks = taskRepository.findAllByUserIdAndIsCompleted(user.getId(), true);
        List<TaskResponse> taskResponseList = taskResponseConverter.apply(allTasks);
        return taskResponseList;

    }

    @Override
    public List<TaskResponse> findAllPendingTask() {
        User user = userProfileService.getUser();
        List<Task> allTasks = taskRepository.findAllByUserIdAndIsCompleted(user.getId(), false);
        List<TaskResponse> taskResponseList = taskResponseConverter.apply(allTasks);
        return taskResponseList;

    }

    @Override
    public Boolean addTask(TaskRequest taskRequest) {
        Task task = new Task();
        User user = userProfileService.getUser();
        task.setPriority(taskRequest.getPriority());
        task.setTaskName(taskRequest.getTaskName());
        task.setUserId(user.getId());
        task.setCompleted(taskRequest.isCompleted());
        task.setTaskDate(UtilFunction.dateFromString(taskRequest.getTaskDate()));
        task.setCreatedBy(user.getId());
        task.setUpdatedBy(user.getId());

        final Task taskResult = taskRepository.save(task);

        return !Objects.isNull(taskResult);
    }

    @Override
    public List<TaskResponse> updateTaskStatus(List<TaskRequest> taskRequests) {

        User user = userProfileService.getUser();
        for (TaskRequest taskRequest :taskRequests) {
            Task task = taskRepository.findByIdAndUserId( taskRequest.getTaskId(),user.getId());
            task.setPriority(taskRequest.getPriority());
            task.setTaskName(taskRequest.getTaskName());
            task.setUserId(user.getId());
            task.setId(taskRequest.getTaskId());
            task.setCompleted(taskRequest.isCompleted());
            task.setTaskDate(UtilFunction.dateFromString(taskRequest.getTaskDate()));
            task.setUpdatedBy(user.getId());
            taskRepository.save(task);
        }
        return findAllPendingTask();
    }

    @Override
    public Boolean removeTask(Long taskId) {
        User user = userProfileService.getUser();
        final Task task = taskRepository.findByIdAndUserId( taskId,user.getId());
        if(Objects.isNull(task)){
            return false;
        }
        taskRepository.delete(task);
        return true;
    }
}
