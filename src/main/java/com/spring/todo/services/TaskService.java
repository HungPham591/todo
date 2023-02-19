package com.spring.todo.services;

import com.spring.todo.model.response.TaskResponse;
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

@Service
public class TaskService extends BaseService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ModelMapper modelMapper;

    public TaskResponse getTask(String id) throws Exception {
        Optional<TaskEntity> taskEntity = taskRepository.findById(id);
        TaskResponse taskDto = modelMapper.map(taskEntity, TaskResponse.class);
        return taskDto;
    }

    public List<TaskResponse> getTasks(Map<String, Object> filter) throws Exception {
        List<TaskEntity> results = taskRepository.getTasksByFilter(filter);

        List<TaskResponse> taskDtos = new ArrayList<>();
        modelMapper.map(results, taskDtos);
        return taskDtos;
    }

    public TaskResponse createTask(TaskInput taskInput) throws Exception {
        TaskEntity taskEntity = new TaskEntity();
        modelMapper.map(taskInput, taskEntity);

        TaskEntity result = taskRepository.save(taskEntity);
        TaskResponse taskDto = modelMapper.map(result, TaskResponse.class);
        return taskDto;
    }

    public List<TaskResponse> createTasks(List<TaskInput> taskRespons) throws Exception {
        List<TaskEntity> taskEntityList = new ArrayList<>();
        modelMapper.map(taskEntityList, taskRespons);
        List<TaskEntity> taskEntities = taskRepository.saveAll(taskEntityList);
        List<TaskResponse> taskDtos = new ArrayList<>();
        modelMapper.map(taskEntities, taskDtos);
        return taskDtos;
    }


    public TaskResponse updateTask(Map<String, Object> filter, TaskInput taskInput) throws Exception {
        TaskEntity taskEntity = new TaskEntity();
        modelMapper.map(taskEntity, taskInput);
        TaskEntity result = taskRepository.save(taskEntity);
        TaskResponse taskDto = modelMapper.map(result, TaskResponse.class);
        return taskDto;
    }


    public void updateTasks(Map<String, Object> filter, TaskInput data) throws Exception {
        taskRepository.updateTask(filter, data);
    }

    public TaskResponse deleteTask(String id) throws Exception {
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setId(id);
        TaskResponse taskDto = new TaskResponse();
        modelMapper.map(taskDto,taskEntity);
        taskRepository.deleteById(id);
        return taskDto;
    }

    public List<TaskResponse> deleteTasks(Map<String, Object> filter) throws Exception {
        taskRepository.deleteTask(filter);
        return new ArrayList<>();
    }
}
