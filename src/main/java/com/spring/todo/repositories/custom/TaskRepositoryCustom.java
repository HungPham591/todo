package com.spring.todo.repositories.custom;

import com.spring.todo.model.entities.TaskEntity;
import com.spring.todo.model.inputs.TaskInput;

import java.util.List;
import java.util.Map;

public interface TaskRepositoryCustom {
    public Map<String,Object> aggregateTaskByUser(String user);

    public List<TaskEntity> getTasksByFilter(Map<String,Object> filter);

    public void updateTask(Map<String, Object> filter, TaskInput data);

    public void deleteTask(TaskInput taskInput);
}
