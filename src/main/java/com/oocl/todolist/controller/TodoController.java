package com.oocl.todolist.controller;

import com.oocl.todolist.exception.GlobalException;
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

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Integer id, @RequestBody Todo todo) throws GlobalException {
        return todoService.updateTodo(id, todo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteTodo(@PathVariable Integer id) throws GlobalException {
        todoService.deleteTodo(id);
        return "success";
    }
}
