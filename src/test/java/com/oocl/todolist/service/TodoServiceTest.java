package com.oocl.todolist.service;

import com.oocl.todolist.dao.TodoDao;
import com.oocl.todolist.model.Todo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class TodoServiceTest {

    private TodoService todoService;
    private final Todo todo = new Todo();

    private final List<Todo> todoList = Arrays.asList(
            new Todo(1, "karen", false),
            new Todo(2, "hovees", true)
    );

    @BeforeEach
    public void init() {
        TodoDao todoDao = Mockito.mock(TodoDao.class);
        this.todoService = new TodoService(todoDao,todo);
        when(todoDao.findAll()).thenReturn(Arrays.asList(
                todoList.get(0),
                todoList.get(1)));
    }

    @Test
    void should_return_todo_list_when_get_all_todo_given_nothing() {
        //when
        List<Todo> todos = todoService.findALl();
        //then
        assertEquals(todoList, todos);
    }
}