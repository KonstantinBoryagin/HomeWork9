//package ru.otus;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.sql.*;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class QuestionDBTest {
//    private static Connection connection;
//    QuestionDB qdb = new QuestionDB();
//
//    @BeforeEach
//    public void init() throws Exception {
//        connection = qdb.getNewConnection();
//    }
//    @AfterEach
//    public void close() throws SQLException {
//        connection.close();
//    }
//
//    @Test
//    void run() {
//    }
//
//    @Test
//    public void shouldSelectData1() throws SQLException {
//        String query = "SELECT * FROM questions WHERE idquestions = ?";
//        PreparedStatement statement = connection.prepareStatement(query);
//        statement.setString(1, "1");
//        boolean hasResult = statement.execute();
//        assertTrue(hasResult);
//    }
//
//    @Test
//    public void shouldSelectData() throws SQLException {
//        String query = "SELECT * FROM questions WHERE idquestions = ?";
//        PreparedStatement statement = connection.prepareStatement(query);
//        statement.setString(1, "1");
//        boolean hasResult = statement.execute();
//        assertTrue(hasResult);
//        // Обработаем результат
//        ResultSet resultSet = statement.getResultSet();
//        resultSet.next();
//        int true_answer = resultSet.getInt("true_answer");
//        assertEquals(3, true_answer);
//    }
//
//    @Test
//    public void selectTest() throws SQLException {
//        String query = "SELECT answer FROM answers WHERE id_question = ?";
//        PreparedStatement statement = connection.prepareStatement(query);
//        statement.setString(1, "1");
//
//        ResultSet resultSet = statement.getResultSet();
//
//    }
//}