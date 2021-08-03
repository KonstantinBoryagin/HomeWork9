package ru.otus;

import java.util.ArrayList;

/**
 *Класс для обработки ответов пользователя
 * и создания ArrayList ответов
 */
public class UserAnswersProcessing {
    private static int countOfCorrect;
    private ArrayList<String> answers = new ArrayList<>();


    public void saveAnswers(int answer, Question question) {
        if (answer == question.getCorrectAnswer()) {
            answers.add("правильно - " + "\"" + question.getAnswerOptions()[question.getCorrectAnswer() - 1] + "\"");
            countOfCorrect++;
        } else {
            answers.add("ошибка. Правильный ответ - " + "\"" + question.getAnswerOptions()[question.getCorrectAnswer() - 1] + "\"");
        }
    }

    public void checkAnswers() {
        System.out.println("");
        for (int i = 0; i < answers.size(); i++) {
            System.out.println((i + 1) + "-й вопрос: " + answers.get(i));
        }
    }

    public int getCountOfCorrect() {
        return countOfCorrect;
    }


    public void clearArrayListWithPlayerAnswers() {
        answers.clear();
    }

    public void resetCountOfCorrect() {
        countOfCorrect = 0;
    }
}
