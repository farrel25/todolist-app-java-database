package com.farrel.todolistapp.util;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseUtilTest {

    @Test
    void testConnection() {
        try {
            HikariDataSource dataSource = DatabaseUtil.getDataSource();

            Connection connection = dataSource.getConnection();

            connection.close();
            dataSource.close();

        } catch (SQLException e) {
            Assertions.fail(e);
        }
    }
}
