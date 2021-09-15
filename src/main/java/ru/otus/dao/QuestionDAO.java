package ru.otus.dao;

import ru.otus.model.Question;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс получает вопросы из MySQL
 */
public class QuestionDAO {

    //    private final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private final static String QUERY_QUESTION = "select idquestions, question, true_answer, answer " +
            "FROM questions INNER JOIN answer ON questions.idquestions = answer.id_question ";

//    public void run() {
//        try {
//            Class.forName(DRIVER_NAME);
//        } catch (ClassNotFoundException e) {
//            System.out.println("Can't get class. No driver found");
//            e.printStackTrace();
//            return;
//        }
//    }

    /**
     * Устанавливает соединение с MySQL
     */
    public Connection getNewConnection() throws SQLException {
        String connectionString = "jdbc:mysql://127.0.0.1:3306/quiz";
        String login = "root";
        String password = "123";
        return DriverManager.getConnection(connectionString, login, password);
    }

    /**
     * Получает все вопросы и варианты ответов из БД, разбивает по вопросам и формирует из них List
     * @return List<Questions>
     */
    public List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();

        try (Connection conn = getNewConnection();
             Statement stmt = conn.createStatement()) {
            ResultSet res = stmt.executeQuery(QUERY_QUESTION);
            String questionString = "";
            int trueAnswer = -1;
            int temp = 0;
            List<String> answers = new ArrayList<>();
            int counter = -1;
            res.next();

           while(true){
               counter = res.getInt(1);
               if(counter != temp) {
                   questionString = res.getString(2);
                   trueAnswer = res.getInt(3);
                   temp++;
               }
               answers.add(res.getString(4));
               if (res.next()) {
                   counter = res.getInt(1);
               } else {
                   Question question = new Question(trueAnswer, questionString, answers);
                   questions.add(question);
                   break;
               }

               if(counter != temp) {
                   Question question = new Question(trueAnswer, questionString, answers);
                   questions.add(question);
                   answers = new ArrayList<>();
               }
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;
    }
}

