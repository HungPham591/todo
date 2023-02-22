package com.spring.todo.services;

import com.spring.todo.repositories.TaskRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest
public class TaskInputServiceTest {
    @InjectMocks
//    @MockBean
    private TaskService taskService;

    @Mock
    private TaskRepository taskRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetTask() throws Exception {
//        Assert.assertEquals(null, taskService.getTask(""));
    }
}
