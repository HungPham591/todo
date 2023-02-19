package com.spring.todo.controllers.v1;

import com.spring.todo.controllers.BaseController;
import com.spring.todo.model.response.TaskResponse;
import com.spring.todo.model.inputs.TaskInput;
import com.spring.todo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/v1/task", produces = MediaType.APPLICATION_JSON_VALUE)
public class TaskController extends BaseController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/task")
    private ResponseEntity<TaskResponse> getTask(@RequestParam("id") String id) throws Exception {
        TaskResponse result = taskService.getTask(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/tasks")
    private ResponseEntity<List<TaskResponse>> getTasks(
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

        List<TaskResponse> result = taskService.getTasks(filter);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/task")
    private ResponseEntity<TaskResponse> createTask(@RequestBody TaskInput taskInput) throws Exception {
        TaskResponse result = taskService.createTask(taskInput);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/tasks")
    private ResponseEntity<List<TaskResponse>> createTasks(@RequestBody List<TaskInput> taskRespons) throws Exception {
        List<TaskResponse> result = taskService.createTasks(taskRespons);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/task")
    private ResponseEntity<TaskResponse> updateTask(@RequestBody TaskInput taskInput, @RequestParam String id) throws Exception {
        Map<String, Object> filter = new HashMap<>();
        filter.put("id", id);

        TaskResponse result = taskService.updateTask(filter, taskInput);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/tasks")
    private ResponseEntity<String> updateTasks(
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

        taskService.updateTasks(filter, tasks);
        return ResponseEntity.ok("string");
    }

    @DeleteMapping("/task")
    private ResponseEntity<String> deleteTask(@RequestParam("id") String id) throws Exception {
        TaskResponse result = taskService.deleteTask(id);
        return ResponseEntity.ok("");
    }

    @DeleteMapping("/tasks")
    private ResponseEntity<String> deleteTasks(@RequestBody Map<String, Object> filter) throws Exception {
        List<TaskResponse> result = taskService.deleteTasks(filter);
        return ResponseEntity.ok("result");
    }
}
