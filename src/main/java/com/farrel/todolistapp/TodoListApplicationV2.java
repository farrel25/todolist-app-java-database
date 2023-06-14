package com.farrel.todolistapp;

import com.farrel.todolistapp.repository.TodoListRepository;
import com.farrel.todolistapp.repository.TodoListRepositoryImpl;
import com.farrel.todolistapp.service.TodoListService;
import com.farrel.todolistapp.service.TodoListServiceImpl;
import com.farrel.todolistapp.util.DatabaseUtil;
import com.farrel.todolistapp.view.TodoListView;

import javax.sql.DataSource;

public class TodoListApplicationV2 {

    public static void main(String[] args) {
        DataSource dataSource = DatabaseUtil.getDataSource();
        TodoListRepository todoListRepository = new TodoListRepositoryImpl(dataSource);
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);

        todoListView.showTodoList();
    }
}