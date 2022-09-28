package com.example.w0926.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.*;

public enum ConnectionUtil{
    INSTANCE; //enum에는 instance하나 선언할수 있는데

    private DataSource dataSource;

    ConnectionUtil()  {
        try {
            Class.forName("org.mariadb.jdbc.Driver");

            HikariConfig config = new HikariConfig();
//            config.setJdbcUrl("jdbc:mariadb://192.168.00.98:3306/webdb");
            config.setJdbcUrl("jdbc:mariadb://localhost:3306/webdb");
            config.setUsername("webuser");
            config.setPassword("webuser");
            config.addDataSourceProperty("cachePrepStmts", "true");
            config.addDataSourceProperty("prepStmtCacheSize", "250");
            config.setMaximumPoolSize(200);

            dataSource = new HikariDataSource(config);
        }catch (Exception e) {
            //bad practice
        }
    }
    public Connection getConnection()throws Exception{
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

