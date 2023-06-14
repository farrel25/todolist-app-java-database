package com.farrel.todolistapp;

import com.farrel.todolistapp.repository.TodoListRepository;
import com.farrel.todolistapp.repository.TodoListRepositoryImpl;
import com.farrel.todolistapp.service.TodoListService;
import com.farrel.todolistapp.service.TodoListServiceImpl;
import com.farrel.todolistapp.view.TodoListView;

public class TodoListApplicationV2 {
    public static void main(String[] args) {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);

        todoListView.showTodoList();
    }
}
