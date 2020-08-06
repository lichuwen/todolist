package com.oocl.todolist.controller;

import com.oocl.todolist.dao.TodoDao;
import com.oocl.todolist.model.Todo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private final TodoDao todoDao;

    public TodoController(TodoDao todoDao) {
        this.todoDao = todoDao;
    }


    @GetMapping
    public List<Todo> getEmployeeInformation() {
        return todoDao.findAll();
    }
}
