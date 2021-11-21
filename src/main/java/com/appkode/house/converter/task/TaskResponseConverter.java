package com.appkode.house.converter.task;

import com.appkode.house.entity.Task;
import com.appkode.house.model.response.task.TaskResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Component
public class TaskResponseConverter implements Function<List<Task>, List<TaskResponse>> {
    @Override
    public List<TaskResponse> apply(List<Task> tasks) {
        List<TaskResponse> taskResponseList = new ArrayList<>();
        for (Task task : tasks) {
            TaskResponse taskResponse = new TaskResponse();
            taskResponse.setTaskDate(task.getTaskDate().toString());
            taskResponse.setTaskName(task.getTaskName());
            taskResponse.setCompleted(task.isCompleted());
            taskResponse.setId(task.getId());
            taskResponse.setPriority(task.getPriority());
            taskResponseList.add(taskResponse);
        }

        return taskResponseList;
    }
}
