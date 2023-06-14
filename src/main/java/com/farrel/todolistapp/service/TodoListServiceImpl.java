package com.farrel.todolistapp.service;

import com.farrel.todolistapp.entity.TodoList;
import com.farrel.todolistapp.repository.TodoListRepository;

public class TodoListServiceImpl implements TodoListService{

    private TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public void showTodoList() {
        TodoList[] todoList = todoListRepository.getAll();

        System.out.println("\nTODO LIST");
        for (var i = 0; i < todoList.length; i++) {
            var num = i + 1;
            if (todoList[i] != null) {
                System.out.println(num + ". " + todoList[i].getTodo());
            }
        }
    }

    @Override
    public void addTodoList(String todo) {
        TodoList todoList = new TodoList(todo);
        todoListRepository.add(todoList);
        System.out.println("Successfully added todo: " + todo);
    }

    @Override
    public void removeTodoList(Integer number) {
        boolean success = todoListRepository.remove(number);
        if (success) {
            System.out.println("\nSuccessfully deleted todo number: " + number);
        } else {
            System.out.println("\nFailed to delete todo number: " + number);
        }
    }
}
