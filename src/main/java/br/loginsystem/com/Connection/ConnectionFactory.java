package br.loginsystem.com.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection() throws SQLException {
        String url = "";
        String username = "";
        String password = "";
        return DriverManager.getConnection(url, password, password);
    }
}
