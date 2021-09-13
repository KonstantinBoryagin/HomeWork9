package ru.otus;

import ru.otus.dao.QuestionDAO;
import ru.otus.model.Question;

import java.util.List;

/**
 * Класс формирует вопросы получаемые из базы данных
 */
public class QuestionGenerator {

    /** Поле - общее количество вопросов заданных пользователю */
    private int countOfQuestions;
    private QuestionDAO questionDAO = new QuestionDAO();

    /**
     * Формирует массив всех вопросов для викторины,
     * присваиваем значение счетчику общего количества вопросов {@link #countOfQuestions}
     * @return - массив всех вопросов с вариантами ответов
     */
    public Question[] formArrayOfQuestions() {
        Question[] arrayOfQuestions = questionDAO.getQuestions();
        countOfQuestions = arrayOfQuestions.length;
        return arrayOfQuestions;
    }

    /**
     * Форматирует и выводит на экран вопрос и варианты ответа
     * @param question - содержит вопрос и варианты ответа
     */
    public void printQuestion(Question question) {
        System.out.println("\n" + question.getQuestion());
        int formatOutput = 0;
        int size = question.getAnswersSize();
        List<String> answers = question.getAnswers();
        for (int i = 0; i < size; i++) {
            System.out.printf("%3d"+ ". " + "%-20s", (i + 1), answers.get(i));
            formatOutput++;
            if (formatOutput % 2 == 0) {
                System.out.println();
            }
        }
        System.out.print("\n Введите номер ответа - ");
    }

    /**
     * Возвращает количество заданных вопросов
     * @return  количество вопросов заданных пользователю
     */
    public int getCountOfQuestions() {
        return countOfQuestions;
    }
}
