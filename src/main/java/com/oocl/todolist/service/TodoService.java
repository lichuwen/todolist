package com.oocl.todolist.service;

import com.oocl.todolist.Enum.ResultEnum;
import com.oocl.todolist.dao.TodoDao;
import com.oocl.todolist.exception.GlobalException;
import com.oocl.todolist.model.Todo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Todo addTodo(Todo todo) {
        return todoDao.save(todo);
    }

    public Todo updateTodo(Integer id, Todo todo) throws GlobalException {
        Optional<Todo> byId = todoDao.findById(id);
        if (byId.isPresent()) {
            Todo oldTodo = byId.get();
            BeanUtils.copyProperties(todo, oldTodo);
            return todoDao.save(oldTodo);
        } else {
            throw new GlobalException(ResultEnum.DATA_NOT_FOUND.getMessage());
        }
    }

}
