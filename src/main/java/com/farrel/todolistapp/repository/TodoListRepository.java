package com.farrel.todolistapp.repository;

import com.farrel.todolistapp.entity.TodoList;

public interface TodoListRepository {

    TodoList[] getAll();

    void add(TodoList todoList);

    boolean remove(Integer number);
}
