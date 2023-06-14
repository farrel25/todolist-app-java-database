package com.farrel.todolistapp.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatabaseUtil {

    private static final HikariDataSource hikariDataSource;

    static {
        HikariConfig hikariConfig = new HikariConfig();

        // connection configuration
        hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/java_todolist");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("");

        // connection pool configuration
        hikariConfig.setMaximumPoolSize(10);
        hikariConfig.setMinimumIdle(5);
        hikariConfig.setIdleTimeout(60_000); // 1s
        hikariConfig.setMaxLifetime(60 * 60 * 1000); // 1h

        hikariDataSource = new HikariDataSource(hikariConfig);
    }

    public static HikariDataSource getDataSource() {
        return hikariDataSource;
    }
}
