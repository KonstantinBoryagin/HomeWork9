package ru.otus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionGeneratorDB {
    QuestionDB db = new QuestionDB();
    Connection connection;

    public QuestionGeneratorDB(Connection connection) {
        this.connection = connection;
    }

    public List<String> getQuestion() throws SQLException {
        String query = "SELECT question FROM questions";
        Statement st = connection.createStatement();
        ResultSet res = st.executeQuery(query);
        ArrayList<String> questions = new ArrayList<>();
        while(res.next()){
             questions.add(res.getString("question"));
        }
        st.close();
        return questions;
    }

    public void getAnswers() throws SQLException {
        String query = "SELECT answer FROM answer WHERE id_question = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, "1");
        ResultSet answers = statement.executeQuery();
//        while(answers.next()) {
//            String temp = answers.getString("answer");
//            System.out.println(temp);
//        }
//        boolean hasResult = statement.execute();
//        System.out.println(hasResult);
        while(answers.next()) {
            String ans = answers.getString("answer");
            System.out.println(ans);
        }
    }
}
