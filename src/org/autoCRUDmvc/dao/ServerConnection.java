package org.autoCRUDmvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ServerConnection {

    public static Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/autocrudmvc";
        String user = "root";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }
}
