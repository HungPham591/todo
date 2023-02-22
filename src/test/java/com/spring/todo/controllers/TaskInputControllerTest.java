package com.spring.todo.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.todo.controllers.v1.TaskController;
import com.spring.todo.model.inputs.TaskInput;
import com.spring.todo.repositories.TaskRepository;
import com.spring.todo.services.TaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;

import static org.mockito.ArgumentMatchers.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
public class TaskInputControllerTest {
    @Autowired
    private MockMvc mvc;

    @Mock
    private TaskService taskService;

    @InjectMocks
    private TaskRepository taskRepository;

    public String asJsonString(final Map map) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(map);
            return jsonContent;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetTask() throws Exception {
        List<TaskInput> listTaskInput = IntStream.range(0, 10).mapToObj(i -> new TaskInput()).collect(Collectors.toList());

//        Mockito.when(taskService.getTasks((any(HashMap.class)))).thenReturn(listTaskInput);

        mvc.perform(get("/v1/task/getTasks").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(10))) // Hi vọng server trả về List độ dài 10
                .andExpect(jsonPath("$[0].id", is(0))) // Hi vọng phần tử trả về đầu tiên có id = 0
                .andExpect(jsonPath("$[0].title", is("title-0"))) // Hi vọng phần tử trả về đầu tiên có title = "title-0"
                .andExpect(jsonPath("$[0].detail", is("detail-0")));
    }
    @Test
    public void testCreateTask() throws Exception {
        List<TaskInput> listTaskInput = IntStream.range(0, 10).mapToObj(i -> new TaskInput()).collect(Collectors.toList());

//        Mockito.when(taskService.getTasks((any(HashMap.class)))).thenReturn(listTaskInput);

        Map<String,Object> body = new HashMap<>();


        mvc.perform(post("/v1/task/getTasks").contentType(MediaType.APPLICATION_JSON).content(asJsonString(body)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(10))) // Hi vọng server trả về List độ dài 10
                .andExpect(jsonPath("$[0].id", is(0))) // Hi vọng phần tử trả về đầu tiên có id = 0
                .andExpect(jsonPath("$[0].title", is("title-0"))) // Hi vọng phần tử trả về đầu tiên có title = "title-0"
                .andExpect(jsonPath("$[0].detail", is("detail-0")));

    }
}
