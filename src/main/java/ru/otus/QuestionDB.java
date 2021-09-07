package ru.otus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QuestionDB {
    private final String driverName = "com.mysql.cj.jdbc.Driver";
//    private final String connectionString = "jdbc:mysql://127.0.0.1:3306/quiz";
//    private final String login = "root";
//    private final String password = "Idontknow89";

    public void run() {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            System.out.println("Can't get class. No driver found");
            e.printStackTrace();
            return;
        }
        try {
            getNewConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        Connection connection;
//        try {
//            connection = DriverManager.getConnection(connectionString, login, password);
//        } catch (SQLException e) {
//            System.out.println("Can't get connection. Incorrect URL");
//            e.printStackTrace();
//            return;
//        }
//        try {
//            connection.close();
//        } catch (SQLException e) {
//            System.out.println("Can't close connection");
//            e.printStackTrace();
//            return;
//        }
    }

    public Connection getNewConnection() throws SQLException {
        String connectionString = "jdbc:mysql://127.0.0.1:3306/quiz";
        String login = "root";
        String password = "Idontknow89";
        return DriverManager.getConnection(connectionString, login, password);
    }



}
