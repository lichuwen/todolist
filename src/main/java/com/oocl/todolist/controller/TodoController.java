package com.oocl.todolist.controller;

import com.oocl.todolist.dao.TodoDao;
import com.oocl.todolist.model.Todo;
import com.oocl.todolist.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }


    @GetMapping
    public List<Todo> getTodoList() {
        return todoService.findALl();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Todo getTodo(@RequestBody Todo todo) {
        return todoService.addTodo(todo);
    }
}
