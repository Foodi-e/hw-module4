package org.example.storage;

import org.example.prefs.Prefs;

import java.sql.*;

public class Database implements AutoCloseable{
    private static final Database INSTANCE = new Database();

    private Connection connection;

    private Database() {
        try {
            String connectionUrl = new Prefs().getString(Prefs.DB_JDBC_CONNECTION_URL);
            connection = DriverManager.getConnection(connectionUrl);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Database getInstance() {
        return INSTANCE;
    }

    public int executeUpdate(String sql) {
        try(PreparedStatement st = connection.prepareStatement(sql)) {
            return st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();

            return -1;
        }
    }

    public Connection getConnection() {
        return connection;
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
