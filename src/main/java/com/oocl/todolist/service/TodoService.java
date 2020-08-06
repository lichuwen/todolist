package com.oocl.todolist.service;

import com.oocl.todolist.dao.TodoDao;
import com.oocl.todolist.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoDao todoDao;
    private final Todo todo;

    public TodoService(TodoDao todoDao, Todo todo) {
        this.todoDao = todoDao;
        this.todo = todo;
    }

    public List<Todo> findALl() {
        return this.todoDao.findAll();
    }

}
