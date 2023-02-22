package com.spring.todo.controllers.v1;

import com.spring.todo.controllers.BaseController;
import com.spring.todo.model.entities.TaskEntity;
import com.spring.todo.model.inputs.TaskInput;
import com.spring.todo.model.response.TaskResponse;
import com.spring.todo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/v1/task", produces = MediaType.APPLICATION_JSON_VALUE)
public class TaskController extends BaseController<TaskEntity, TaskResponse> {

    @Autowired
    private TaskService taskService;

    @GetMapping("/task")
    private ResponseEntity<TaskResponse> getTask(Authentication authentication, @RequestParam("id") String id) throws Exception {
        TaskEntity result = taskService.getTask(authentication.getName(), id);
        return success(result);
    }

    @GetMapping("/tasks")
    private ResponseEntity<List<TaskResponse>> getTasks(
            Authentication authentication,
            @RequestParam(value = "assignee", required = false) String assignee,
            @RequestParam(value = "assigner", required = false) String assigner,
            @RequestParam(value = "group", required = false) String group,
            @RequestParam(value = "timeStart", required = false) Date start,
            @RequestParam(value = "timeEnd", required = false) Date end,
            @RequestParam(value = "skip", required = false) Integer skip,
            @RequestParam(value = "limit", required = false) Integer limit
    ) throws Exception {
        Map<String, Object> filter = new HashMap<>();
        filter.put("assignee", assignee);
        filter.put("assigner", assigner);
        filter.put("group", group);
        filter.put("start", start);
        filter.put("end", end);
        filter.put("skip", skip);
        filter.put("limit", limit);

        List<TaskEntity> result = taskService.getTasks(authentication.getName(), filter);
        return success(result);
    }

    @PostMapping("/task")
    private ResponseEntity<TaskResponse> createTask(Authentication authentication, @RequestBody TaskInput taskInput) throws Exception {
        TaskEntity result = taskService.createTask(authentication.getName(), taskInput);
        return success(result);
    }

    @PostMapping("/tasks")
    private ResponseEntity<List<TaskResponse>> createTasks(Authentication authentication, @RequestBody List<TaskInput> input) throws Exception {
        List<TaskEntity> result = taskService.createTasks(authentication.getName(), input);
        return success(result);
    }

    @PutMapping("/task")
    private ResponseEntity<TaskResponse> updateTask(
            Authentication authentication,
            @RequestBody TaskInput taskInput,
            @RequestParam String id) throws Exception {
        Map<String, Object> filter = new HashMap<>();
        filter.put("id", id);

        TaskEntity result = taskService.updateOneTask(authentication.getName(), id, taskInput);
        return success(result);
    }

    @PutMapping("/tasks")
    private ResponseEntity<TaskResponse> updateTasks(
            Authentication authentication,
            @RequestBody TaskInput tasks,
            @RequestParam(value = "assigner", required = false) String assigner,
            @RequestParam(value = "assignee", required = false) String assignee,
            @RequestParam(value = "group", required = false) String group,
            @RequestParam(value = "id", required = false) String id,
            @RequestParam(value = "start", required = false) Date timeStart,
            @RequestParam(value = "end", required = false) Date timeEnd
    ) throws Exception {
        Map<String, Object> filter = new HashMap<>();
        filter.put("assigner", assigner);
        filter.put("assignee", assignee);
        filter.put("group", group);
        filter.put("id", id);
        filter.put("start", timeStart);
        filter.put("end", timeEnd);

        taskService.updateTasks(authentication.getName(), filter, tasks);
        return success();
    }

    @DeleteMapping("/task")
    private ResponseEntity<TaskResponse> deleteTask(Authentication authentication, @RequestParam("id") String id) throws Exception {
        TaskEntity result = taskService.deleteTask(authentication.getName(), id);
        return success(result);
    }

    @DeleteMapping("/tasks")
    private ResponseEntity<List<TaskResponse>> deleteTasks(Authentication authentication, @RequestBody List<TaskInput> input) throws Exception {
        List<TaskEntity> result = taskService.deleteTasks(authentication.getName(), input);
        return success(result);
    }
}
