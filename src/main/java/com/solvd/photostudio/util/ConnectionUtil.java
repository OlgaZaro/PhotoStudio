package com.solvd.photostudio.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class ConnectionUtil<T> {
    protected static Connection connection;

    public ConnectionUtil(String host, String name, String password) {
        try {
            ConnectionPool connectionPool = ConnectionPool.createConnectionPool(host, name, password);
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static PreparedStatement getPrepareStatement(String sql, int returnGeneratedKeys) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql, returnGeneratedKeys);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    public static PreparedStatement getPrepareStatement(String sql) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }
}
