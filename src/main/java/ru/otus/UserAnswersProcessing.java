package ru.otus;

import java.util.ArrayList;

/**
 *Класс для обработки ответов пользователя и создания ArrayList ответов
 */
public class UserAnswersProcessing {
    private static int countOfCorrect;
    private ArrayList<String> answers = new ArrayList<>();


    /**
     *  Проверка на правильность ответа данного пользователем и дальнейшая его запись в ArrayList с ответами.
     *  Инкриминирует счетчик правильных ответов {@link #countOfCorrect}
     * @param answer - вариант ответа введенный пользователем
     * @param question - вопрос
     */
    public void saveAnswers(int answer, Question question) {
        if (answer == question.getCorrectAnswer()) {
            answers.add("правильно - " + "\"" + question.getAnswerOptions()[question.getCorrectAnswer() - 1] + "\"");
            countOfCorrect++;
        } else {
            answers.add("ошибка. Правильный ответ - " + "\"" + question.getAnswerOptions()[question.getCorrectAnswer() - 1] + "\"");
        }
    }

    /**
     * Вывод в консоль ArrayList с правильными и ошибочными ответами пользователями (с указанием верных)
     */
    public void outputStatisticOfResponses() {
        System.out.println("");
        for (int i = 0; i < answers.size(); i++) {
            System.out.println((i + 1) + "-й вопрос: " + answers.get(i));
        }
    }

    /**
     * Получает значение поля {@link #countOfCorrect}
     * @return Значение количества правильных ответов пользователя
     */
    public static int getCountOfCorrect() {
        return countOfCorrect;
    }


    /**
     * Очищаем ArrayList {@link #answers} содержащий ответы пользователя
     */
    public void clearArrayListWithPlayerAnswers() {
        answers.clear();
    }

    /**
     * Обнуляем поле {@link #countOfCorrect} содержащее количество правильных ответов пользователя
     */
    public static void resetCountOfCorrect() {
        countOfCorrect = 0;
    }
}
