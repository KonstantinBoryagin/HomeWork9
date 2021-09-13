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
    private final static String QUERY_COUNTER = "SELECT idquestions FROM questions";
    private final static String QUERY_QUESTION = "select question, true_answer, answer " +
            "FROM questions INNER JOIN answer ON questions.idquestions = answer.id_question " +
            "WHERE id_question = ?";

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
        String password = "Idontknow89";
        return DriverManager.getConnection(connectionString, login, password);
    }

    /**
     * Получает общее количество вопрос из БД
     * @return количество вопросов
     */
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

    /**
     * Формирует массив вопросов
     * {@link Question#Question(int, String, List)}
     * @return массив вопросов
     */
    public Question[] getQuestions() {
        int counter = getCounter();
        Question[] questions = new Question[counter];

        try (Connection conn = getNewConnection();
            PreparedStatement stmt = conn.prepareStatement(QUERY_QUESTION)){
            for (int i = 0; i < counter; i++) {
                questions[i] = getQuestion(i + 1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;
    }

    /**
     * Получает вопрос из БД
     * @param parameter - номер нужного вопроса
     * @return - вопрос {@link Question#Question(int, String, List)}
     */
    public Question getQuestion(int parameter) {
        List<String> answers = new ArrayList<>();
        String questionString = "";
        int trueAnswer = -1;

        try (Connection conn = getNewConnection();
            PreparedStatement stmt = conn.prepareStatement(QUERY_QUESTION)){
            stmt.setInt(1, parameter);
            ResultSet result = stmt.executeQuery();
            while(result.next()) {
                questionString = result.getString("question");
                trueAnswer = result.getInt("true_answer");
                answers.add(result.getString("answer"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Question question = new Question(trueAnswer, questionString,answers);
        return question;
    }

}

