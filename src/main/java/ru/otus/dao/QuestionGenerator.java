package ru.otus.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Question {

    private final static String QUERY_COUNTER = "SELECT idquestions FROM questions";
    private final static String QUERY_QUESTION = "select question, true_answer, answer " +
            "FROM questions INNER JOIN answer ON questions.idquestions = answer.id_question " +
            "WHERE id_question = ?";

    public Connection getNewConnection() throws SQLException {
        String connectionString = "jdbc:mysql://127.0.0.1:3306/quiz";
        String login = "root";
        String password = "Idontknow89";
        return DriverManager.getConnection(connectionString, login, password);
    }

    public int getCounter() {
        int counter = 0;
        try (Connection conn = getNewConnection();
             Statement stmt = conn.createStatement()) {
            ResultSet res = stmt.executeQuery(QUERY_COUNTER);
            while(res.next()){
                counter++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return counter;
    }

    public Question getQuestion() throws SQLException {
        List<String> answers = new ArrayList<>();
        String question;
        int trueAnswer;

        try (Connection conn = getNewConnection();
            PreparedStatement stmt = conn.prepareStatement(QUERY_QUESTION)){
            stmt.setInt(1, 1);
            ResultSet result = stmt.executeQuery();
            while(result.next()) {
                question = result.getString("question");
                trueAnswer = result.getInt("true_answer");
                answers.add(result.getString())
            }
        }


    }

}

