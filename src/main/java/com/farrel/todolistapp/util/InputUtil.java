package com.farrel.todolistapp.util;

public class InputUtil {

    private static final java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static String input(String info) {
        System.out.print("\n" + info + ": ");
        //String data = scanner.nextLine();
        //return data;
        return scanner.nextLine();
    }
}
