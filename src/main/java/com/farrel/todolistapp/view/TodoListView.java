package com.farrel.todolistapp.view;

import com.farrel.todolistapp.service.TodoListService;
import com.farrel.todolistapp.util.InputUtil;

public class TodoListView {

    private TodoListService todoListService;

    public TodoListView(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    public void showTodoList() {
        //label:
        while (true) {
            //showTodoList();
            todoListService.showTodoList();

            System.out.println("\nMENU: ");
            System.out.println("1. Add new task");
            System.out.println("2. Delete task");
            System.out.println("3. Exit");

            var menuChosen = InputUtil.input("Choose menu (just type the number of menu)");

            if (menuChosen.equals("1")) {
                //viewAddTodoList();
                addTodoList();
            } else if (menuChosen.equals("2")){
                //viewRemoveTodoList();
                removeTodoList();
            } else if (menuChosen.equals("3")) {
                break;
            } else {
                System.out.println("\nInput invalid (just type number of menu)\n");
            }
//            switch (menuChosen) {
//                case "1":
//                    //viewAddTodoList();
//                    addTodoList();
//                    break;
//                case "2":
//                    //viewRemoveTodoList();
//                    removeTodoList();
//                    break;
//                case "3":
//                    break;
//                default:
//                    System.out.println("\nInput invalid (just type number of menu)\n");
//                    break;
//            }

        }
    }

    public void addTodoList(){
        System.out.println("\nADD NEW TASK");
        String newData = InputUtil.input("Input new task (type x to cancel)");

        if (newData.equals("x")) {
            // cancel
            //viewShowTodoList();
            showTodoList();
        } else {
            //addTodoList(newData);
            todoListService.addTodoList(newData);
        }
    }

    public void removeTodoList() {
        System.out.println("\n DELETE TASK");
        String dataToDel = InputUtil.input("Input task number (type x to cancel)");

        if (dataToDel.equals("x")) {
            // cancel
            //viewShowTodoList();
            showTodoList();
        } else {
//            boolean success = removeTodoList(Integer.valueOf(dataToDel));
//            if (!success) {
//                System.out.println("Failed to delete task number " + dataToDel);
//            }
            todoListService.removeTodoList(Integer.valueOf(dataToDel));
        }
    }
}
