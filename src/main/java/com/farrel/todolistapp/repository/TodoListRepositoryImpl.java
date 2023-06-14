package com.farrel.todolistapp.repository;

import com.farrel.todolistapp.entity.TodoList;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoListRepositoryImpl implements TodoListRepository{

    private final DataSource dataSource;

    public TodoListRepositoryImpl(DataSource dataSource) {
        this.dataSource=dataSource;
    }

    @Override
    public TodoList[] getAll() {
        String sql = "SELECT * FROM todolist";

        try(
                Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)
        ) {
            List<TodoList> todoListList = new ArrayList<>();

            while (resultSet.next()) {
                TodoList todoList = new TodoList();
                todoList.setId(resultSet.getInt("id"));
                todoList.setTodo(resultSet.getString("todo"));

                todoListList.add(todoList);
            }

            return todoListList.toArray(new TodoList[]{});

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(TodoList todoList) {
        String sql = "INSERT INTO todolist (todo) VALUES (?)";

        try(
                //Connection connection = DatabaseUtil.getDataSource().getConnection();
                Connection connection = dataSource.getConnection();
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
        if (!isExists(number)) {
            return false;
        }

        String sql = "DELETE FROM todolist WHERE id = ?";

        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setInt(1, number);
            preparedStatement.executeUpdate();

            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isExists(Integer number) {
        String sql = "SELECT id FROM todolist WHERE id = ?";

        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setInt(1, number);

            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
