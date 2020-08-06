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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class TodoServiceTest {

    private TodoService todoService;
    private final Todo todo = new Todo();

    private final List<Todo> todoList = Arrays.asList(
            new Todo(1, "karen", false),
            new Todo(2, "lichwuen", true)
    );

    @BeforeEach
    public void init() {
        TodoDao todoDao = Mockito.mock(TodoDao.class);
        this.todoService = new TodoService(todoDao,todo);
        when(todoDao.findAll()).thenReturn(Arrays.asList(
                todoList.get(0),
                todoList.get(1)));
        when(todoDao.save(any(Todo.class))).thenReturn(todoList.get(0));
    }

    @Test
    void should_return_todo_list_when_get_all_todo_given_nothing() {
        //when
        List<Todo> todos = todoService.findALl();
        //then
        assertEquals(todoList, todos);
    }

    @Test
    void should_add_a_todo_when_add_new_todo_given_todo() {
        //given
        Todo todo = new Todo(1, "karen", false);

        //when
        Todo newTodo = todoService.addTodo(todo);

        //then
        assertEquals(todo, newTodo);
    }
}