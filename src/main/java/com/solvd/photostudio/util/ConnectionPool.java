package com.solvd.photostudio.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private final String host;
    private final String name;
    private final String password;
    private final List<Connection> connectionPool;
    protected final List<Connection> useConnections = new ArrayList<>();
    private static final int INITIAL_POOL_SIZE = 5;

    public ConnectionPool(String host, String name, String password, List<Connection> connectionPool) {
        this.host = host;
        this.name = name;
        this.password = password;
        this.connectionPool = connectionPool;
    }

    public String getHOST() { return host; }

    public String getName() { return name; }

    public String getPassword() { return password; }

    public static ConnectionPool createConnectionPool(String host, String name, String password) throws SQLException {
        List<Connection> pool = new ArrayList<>(INITIAL_POOL_SIZE);
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            pool.add(createConnection(host, name, password));
        }
        return new ConnectionPool(host, name, password, pool);
    }

    public Connection getConnection() {
        Connection connection = connectionPool.remove(connectionPool.size() - 1);
        useConnections.add(connection);
        return connection;
    }

    public static Connection createConnection(String host, String name, String password) throws SQLException {
        Connection connection = DriverManager.getConnection(host, name, password);
        if (connection != null) {
            //System.out.println("Successfully connected");
        } else {
            System.out.println("Can not establish connection to DB");
        }
        return connection;
    }
}

