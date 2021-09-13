package ru.otus;

import ru.otus.dao.QuestionGenerator;
import ru.otus.model.Question;

import java.sql.SQLException;

/**
 * "Викторина"
 * @author Konstantin Boryagin
 * @version 1.0
 */
public class Quiz {


    public static void main(String[] args) throws SQLException {
        QuestionDB app = new QuestionDB();
        QuestionGeneratorDB db = new QuestionGeneratorDB(app.getNewConnection());
        QuestionGenerator questionGenerator = new QuestionGenerator();
        //app.run();
            System.out.println(questionGenerator.getCounter());
           // db.getAnswers();
        Question q1 = questionGenerator.getQuestion(1);
        System.out.println(q1.getQuestion());
        System.out.println(q1.getTrueAnswer());
        System.out.println(q1.getAnswers());



//        QuizGenerator quizGenerator = new QuizGenerator();
//
//        System.out.println("Добро пожаловать! Введите Ваше имя что бы начать!");
//
//        /** Получаем и записываем имя пользователя в {@link QuizGenerator#setPlayerName(String name)} */
//        quizGenerator.setPlayerName(quizGenerator.getInput().nextLine());
//
//        /**
//         * Вызываем метод пошагового выполнения викторины {@link QuizGenerator#quiz()}
//         * пока не будет введена "Q" для выхода из программы
//         */
//        while (true) {
//            quizGenerator.quiz();
//
//            System.out.println("\n Что бы выйти введите \"Q\" или что либо другое для следующей попытки");
//
//            if (quizGenerator.getInput().next().equalsIgnoreCase("q")) {
//                return;
//            } else {
//                System.out.println("Начнем заново!");
//            }
//        }
    }
}
