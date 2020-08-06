package com.oocl.todolist.integration;

import com.oocl.todolist.dao.TodoDao;
import com.oocl.todolist.model.Todo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TodoControllerTest {

    private final List<Todo> todoList = Arrays.asList(
            new Todo(1, "Karen", false),
            new Todo(2, "emon", false),
            new Todo(3, "Jeany", false),
            new Todo(4, "Woody", false)
    );

    @Autowired
    TodoDao todoDao;
    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void init() {
        todoDao.save(todoList.get(0));
        todoDao.save(todoList.get(1));
        todoDao.save(todoList.get(2));
        todoDao.save(todoList.get(3));
    }

    @AfterEach
    void tearDown() {
        todoDao.deleteAll();
    }


    @Test
    void should_get_todo_list_when_hit_get_todo_endpoint_given_nothing() throws Exception {
        //when
        mockMvc.perform(get("/todos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(4))
                .andExpect(jsonPath("$[0].text").value("Karen"))
                .andExpect(jsonPath("$[0].status").value(false))
                .andExpect(jsonPath("$[1].text").value("emon"))
                .andExpect(jsonPath("$[1].status").value(false));
    }
}
