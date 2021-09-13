//package ru.otus;
//
//import org.junit.jupiter.api.Test;
//
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class QuestionGeneratorTest {
//
//    @Test
//    void formArrayOfQuestions() {
//    }
//
//    @Test
//    public void printQuestion() {
//        String consoleOutput = "";
//        PrintStream originOut = System.out;
//        try {
//            ByteArrayOutputStream outputStream = new ByteArrayOutputStream(100);
//            PrintStream capture = new PrintStream(outputStream);
//            System.setOut(capture);
//            QuestionGenerator temp = new QuestionGenerator();
//            Question test = Question.QUESTION_ONE;
//            temp.printQuestion(test);
//            capture.flush();
//            consoleOutput = outputStream.toString();
//            System.setOut(originOut);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        assertEquals("\nСколько примитивных типов данных в Java?\n" +
//                "  1. Десять                2. Пять                \n" +
//                "  3. Восемь              \n" +
//                " Введите номер ответа - ", consoleOutput);
//    }
//
//
//    @Test
//    void getCountOfQuestions() {
//    }
//}