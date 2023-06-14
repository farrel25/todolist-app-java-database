package com.farrel.todolistapp.repository;

import com.farrel.todolistapp.entity.TodoList;
import com.farrel.todolistapp.util.DatabaseUtil;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class TodoListRepositoryImplTest {

    private HikariDataSource dataSource;
    private TodoListRepository todoListRepository;

    @BeforeEach
    void setUp() {
        dataSource = DatabaseUtil.getDataSource();
        todoListRepository = new TodoListRepositoryImpl(dataSource);
    }

    @AfterEach
    void tearDown() {
        dataSource.close();
    }

    @Test
    void testAdd() {
        TodoList todoList = new TodoList();
        todoList.setTodo("Learn Java Database");

        todoListRepository.add(todoList);
    }

    @Test
    void testRemove() {
        int idToRemove = 2;

        boolean isRemove1Success = todoListRepository.remove(idToRemove);
        System.out.println("isRemove1Success : " + isRemove1Success);
        Assertions.assertTrue(isRemove1Success);

        boolean isRemove1Fail = todoListRepository.remove(idToRemove);
        System.out.println("isRemove1Fail : " + isRemove1Fail);
        Assertions.assertFalse(isRemove1Fail);
    }
}
