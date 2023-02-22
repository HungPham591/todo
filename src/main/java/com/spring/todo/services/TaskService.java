package com.spring.todo.services;

import com.spring.todo.model.entities.TaskEntity;
import com.spring.todo.model.inputs.TaskInput;
import com.spring.todo.repositories.TaskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService extends BaseService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ModelMapper modelMapper;

    public TaskEntity getTask(String user, String id) throws Exception {
        Optional<TaskEntity> taskEntity = taskRepository.findById(id);
        return taskEntity.get();
    }

    public List<TaskEntity> getTasks(String user, Map<String, Object> filter) throws Exception {
        List<TaskEntity> results = taskRepository.getTasksByFilter(filter);
        return results;
    }

    public TaskEntity createTask(String user, TaskInput taskInput) throws Exception {
        TaskEntity result = taskRepository.save(taskInput.toEntity());
        return result;
    }

    public List<TaskEntity> createTasks(String user, List<TaskInput> taskInputs) throws Exception {
        List<TaskEntity> taskEntityList = taskInputs.stream().map(input -> input.toEntity()).collect(Collectors.toList());
        List<TaskEntity> taskEntities = taskRepository.saveAll(taskEntityList);
        return taskEntities;
    }

    public TaskEntity updateOneTask(String user, String id, TaskInput taskInput) {
        return null;
    }

    public void updateTask(String user, Map<String, Object> filter, TaskInput taskInput) throws Exception {
        taskRepository.updateTask(filter, taskInput);
    }


    public void updateTasks(String user, Map<String, Object> filter, TaskInput data) throws Exception {
        taskRepository.updateTask(filter, data);
    }

    public TaskEntity deleteTask(String user, String id) throws Exception {
        taskRepository.deleteById(id);
        return new TaskEntity();
    }

    public List<TaskEntity> deleteTasks(String user, List<TaskInput> input) throws Exception {
//        taskRepository.deleteTask(input);
        return new ArrayList<>();
    }
}
