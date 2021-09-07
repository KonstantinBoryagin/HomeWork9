package ru.otus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionGeneratorDB {
    QuestionDB db = new QuestionDB();
    Connection connection;

    public QuestionGeneratorDB(Connection connection) {
        this.connection = connection;
    }

    public void getAnswers() throws SQLException {
        String query = "SELECT answer FROM answers WHERE id_question = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, "1");
        ResultSet answers = statement.getResultSet();
//        while(answers.next()) {
//            String temp = answers.getString("answer");
//            System.out.println(temp);
//        }
//        boolean hasResult = statement.execute();
//        System.out.println(hasResult);
        answers.next();
        String ans = answers.getString("answer");
        System.out.println(ans);
    }
}
