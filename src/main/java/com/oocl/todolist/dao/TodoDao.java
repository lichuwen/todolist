package com.oocl.todolist.dao;

import com.oocl.todolist.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoDao extends JpaRepository<Todo, Integer> {
}
