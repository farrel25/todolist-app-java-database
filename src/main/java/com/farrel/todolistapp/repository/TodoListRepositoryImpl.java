package com.farrel.todolistapp.repository;

import com.farrel.todolistapp.entity.TodoList;
import com.farrel.todolistapp.util.DatabaseUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TodoListRepositoryImpl implements TodoListRepository{

    public TodoList[] data = new TodoList[10];

    private final DataSource dataSource;

    private TodoListRepositoryImpl(DataSource dataSource) {
        this.dataSource=dataSource;
    }

    @Override
    public TodoList[] getAll() {
        return data;
    }

    public boolean isFull() {

        // check if the model is full, no index have null value
        var isFull = true;
//        for (var i = 0; i < model.length; i++) {
//            if (model[i] == null) {
//                isFull = false;
//                break;
//            }
//        }
        for (TodoList d : data) {
            if (d == null) {
                // models are still available (masih ada yg kosong)
                isFull = false;
                break;
            }
        }

        return isFull;
    }

    public void resizeIfFull() {

        // if isFull is true, resize array 2 times bigger
        if (isFull()) {
            var temp = data;
            //model = new String[model.length * 2];
            data = new TodoList[data.length * 2];

//            for (var i = 0; i < temp.length; i++) {
//                    //model[i] = temp[i];
//                    data[i] = temp[i];
//            }
            System.arraycopy(temp, 0, data, 0, temp.length);
        }
    }

    @Override
    public void add(TodoList todoList) {
//        // if isFull() is true, resize array 2 times bigger
//        resizeIfFull();
//
//        // add data where the value is null
//        for (var i = 0; i < data.length; i++) {
//            if (data[i] == null) {
//                data[i] = todoList;
//                break;
//            }
//        }
        String sql = "INSERT INTO todolist (todo) VALUES (?)";

        try(
                Connection connection = DatabaseUtil.getDataSource().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setString(1, todoList.getTodo());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean remove(Integer number) {
        if (number >= data.length || number < 1) {
             return false;
        }else if (data[number-1] == null) {
            return false;
        } else {
            for (int i = (number-1); i < data.length; i++) {
                if (i == data.length - 1) {
                    data[i] = null;
                } else {
                    data[i] = data[i+1];
                }
            }
            return true;
        }
    }
}
