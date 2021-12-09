package com.appkode.house.controller.secure;


import com.appkode.house.model.request.task.TaskRequest;
import com.appkode.house.model.response.generic.GenericResponse;
import com.appkode.house.model.response.task.TaskResponse;
import com.appkode.house.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {
    private final TaskService taskService;


    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @GetMapping(value = "/getAllTask")
    public ResponseEntity<List<TaskResponse>> getAllTask() {
        List<TaskResponse> taskResponseList = taskService.findAllTask();
        return new ResponseEntity<>(taskResponseList, HttpStatus.OK);
    }

    @PostMapping(value = "/addTask")
    public ResponseEntity<GenericResponse> addTask(@RequestBody TaskRequest taskRequest) {
        Boolean result = taskService.addTask(taskRequest);
        if (result) {
            return new ResponseEntity<>(new GenericResponse(0, "Success", "Task added successfully."), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new GenericResponse(99, "Failed", "Unable to add task."), HttpStatus.OK);

        }
    }

    @PostMapping(value = "/updateTask")
    public ResponseEntity<List<TaskResponse>> updateTask(@RequestBody List<TaskRequest> taskRequests) {
        List<TaskResponse> taskResponseList = taskService.updateTaskStatus(taskRequests);
        return new ResponseEntity<>(taskResponseList, HttpStatus.OK);
    }

    @DeleteMapping(value = "/removeTask/{taskId}")
    public ResponseEntity<GenericResponse> removeTask(@PathVariable Long taskId) {
        Boolean result = taskService.removeTask(taskId);
        if (result) {
            return new ResponseEntity<>(new GenericResponse(0, "Success", "Task deleted successfully."), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new GenericResponse(99, "Failed", "Unable to delete task."), HttpStatus.OK);

        }
    }


    @GetMapping(value = "/getAllCompletedTask")
    public ResponseEntity<List<TaskResponse>> getAllCompletedTask() {
        List<TaskResponse> taskResponseList = taskService.findAllCompetedTask();
        return new ResponseEntity<>(taskResponseList, HttpStatus.OK);
    }


    @GetMapping(value = "/getAllPendingTask")
    public ResponseEntity<List<TaskResponse>> getAllPendingTask() {
        List<TaskResponse> taskResponseList = taskService.findAllPendingTask();
        return new ResponseEntity<>(taskResponseList, HttpStatus.OK);
    }


}
