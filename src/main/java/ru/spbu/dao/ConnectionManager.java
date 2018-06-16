package ru.spbu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

final class ConnectionManager {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String dbUrl = "jdbc:mysql://localhost:3306/calculator?serverTimezone=UTC&verifyServerCertificate=false&useSSL=true";
    private static String dbUser = "root";
    private static String dbPassword = "root";

    private static Connection connection;

    private ConnectionManager() {

    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (connection == null) {
            Class.forName(driver);
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        }

        return connection;
    }
}
