package ru.otus;

import java.sql.*;

public class QuestionDB {
    private final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

    public void run() {
        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            System.out.println("Can't get class. No driver found");
            e.printStackTrace();
            return;
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
