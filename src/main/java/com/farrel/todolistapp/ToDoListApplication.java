package com.farrel.todolistapp;

public class ToDoListApplication {

    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
//        testShowTodoList();
//        testAddTodoList();
//        testRemoveTodoList();
//        testInput();
//        testViewShowTodoList();
//        testViewAddTodoList();
//        testViewRemoveTodoList();
        viewShowTodoList();

//        addTodoList("todo 1");
//        addTodoList("todo 2");
//        addTodoList("todo 3");
//        showTodoList();
//
//        System.out.println(removeTodoList(4));
//        showTodoList();
//
//        System.out.println(removeTodoList(3));
//        showTodoList();
//
//        System.out.println(removeTodoList(1));
//        showTodoList();
//
//        addTodoList("todo 4");
//        addTodoList("todo 5");
//        showTodoList();
//
//        System.out.println(removeTodoList(2));
//        showTodoList();
//
//        addTodoList("todo 6");
//        showTodoList();
//
//        System.out.println(removeTodoList(0));
//        showTodoList();
    }



    /*
     * BUSINESS LOGIC
     */

    /**
     * read todo list
     */
    public static void showTodoList() {
        System.out.println("\nTODO LIST");
        for (var i = 0; i < model.length; i++) {
            var num = i + 1;
            if (model[i] != null) {
                System.out.println(num + ". " + model[i]);
            }
        }
    }

    /**
     * create todo from list
     */
    public static void addTodoList(String todo) {
        // check if the model is full, no index have null value
        var isFull = true;
//        for (var i = 0; i < model.length; i++) {
//            if (model[i] == null) {
//                isFull = false;
//                break;
//            }
//        }
        for (String s : model) {
            if (s == null) {
                isFull = false;
                break;
            }
        }

        // if isFull is true, resize array 2 times bigger
        if (isFull) {
            var temp = model;
            model = new String[model.length * 2];

//            for (var i = 0; i < temp.length; i++) {
//                    model[i] = temp[i];
//            }
            System.arraycopy(temp, 0, model, 0, temp.length);
        }

        // add data where the value is null
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    /**
     * delete todo from list
     */
    public static boolean removeTodoList(Integer number) {
        if (number >= model.length || number < 1) {
             return false;
        }else if (model[number-1] == null) {
            return false;
        } else {
            for (int i = (number-1); i < model.length; i++) {
                if (i == model.length - 1) {
                    model[i] = null;
                } else {
                    model[i] = model[i+1];
                }
            }
            return true;
        }


    }



    /**
     * BUSINESS LOGIC TEST
     */

    public static void testShowTodoList() {
        model[0] = "Learn java basic";
        model[1] = "Learn java basic study case";
        showTodoList();
    }

    public static void testAddTodoList() {
        for (int i = 0; i < 25; i++) {
            addTodoList("Todo ke-" + (i+1));
        }
        showTodoList();
    }

    public static void testRemoveTodoList() {
        addTodoList("one");
        addTodoList("two");
        addTodoList("three");
        addTodoList("four");
        addTodoList("five");

        System.out.println(removeTodoList(6));
        System.out.println(removeTodoList(10));
        System.out.println(removeTodoList(20));
        System.out.println(removeTodoList(-1));
        System.out.println(removeTodoList(2));

        showTodoList();
    }


    /**
     * INPUT FUNCTION
     * @return String
     */
    public static String input(String info) {
        System.out.print("\n" + info + ": ");
        //String data = scanner.nextLine();
        //return data;
        return scanner.nextLine();
    }

    public static void testInput() {
        var data = input("name");
        System.out.println("Hi " + data);
    }



    /*
     * VIEW
     */

    /**
     * Show view todo list
     */
    public static void viewShowTodoList() {
        label:
        while (true) {
            showTodoList();

            System.out.println("\nMENU: ");
            System.out.println("1. Add new task");
            System.out.println("2. Delete task");
            System.out.println("3. Exit");

            var menuChosen = input("Choose menu (just type the number of menu)");
//            if (menuChosen.equals("1")) {
//                viewAddTodoList();
//            } else if (menuChosen.equals("2")){
//                viewRemoveTodoList();
//            } else if (menuChosen.equals("3")) {
//                break;
//            } else {
//                System.out.println("\nInput invalid (just type number of menu)\n");
//            }
            switch (menuChosen) {
                case "1":
                    viewAddTodoList();
                    break;
                case "2":
                    viewRemoveTodoList();
                    break;
                case "3":
                    break label;
                default:
                    System.out.println("\nInput invalid (just type number of menu)\n");
                    break;
            }
        }
    }

    /**
     * show view create todo list
     */
    public static void viewAddTodoList() {
        System.out.println("\nADD NEW TASK");
        String newData = input("Input new task (type x to cancel)");

        if (newData.equals("x")) {
            // cancel
            viewShowTodoList();
        } else {
            addTodoList(newData);
        }
    }

    /**
     * show view delete todo list
     */
    public static void viewRemoveTodoList() {
        System.out.println("\n DELETE TASK");
        String dataToDel = input("Input task number (type x to cancel)");


        if (dataToDel.equals("x")) {
            // cancel
            viewShowTodoList();
        } else {
            boolean success = removeTodoList(Integer.valueOf(dataToDel));
            if (!success) {
                System.out.println("Failed to delete task number " + dataToDel);
            }
        }
    }



    public static void testViewShowTodoList() {
        addTodoList("One");
        addTodoList("Two");
        addTodoList("Three");
        addTodoList("Four");
        addTodoList("Five");
        viewShowTodoList();
    }

    public static void testViewAddTodoList() {
        addTodoList("One");
        addTodoList("Two");
        addTodoList("Three");

        viewAddTodoList();

        showTodoList();
    }

    public static void testViewRemoveTodoList() {
        addTodoList("One");
        addTodoList("Two");
        addTodoList("Three");
        addTodoList("Four");
        addTodoList("Five");

        viewRemoveTodoList();

        showTodoList();
    }
}
