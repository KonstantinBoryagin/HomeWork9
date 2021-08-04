package ru.otus;

import java.util.Scanner;

/**
 * Класс создания Викторины
 */
public class QuizGenerator {
    /** Поле - общее количество вопросов заданных пользователю */
    private int countOfQuestions;
    /** Поле - имя пользователя, задется в методе {@link #setPlayerName(String)} */
    private String playerName;
    private final Scanner input = new Scanner(System.in);
    private final UserAnswersProcessing userAnswersProcessing = new UserAnswersProcessing();

    public Scanner getInput() {
        return input;
    }

    /**
     * Метод для пошагового выполнения викторины с помощью вызовов
     * {@link #askQuestions()},
     * {@link #resultForQuiz()},
     * {@link #displayAnswerStatistic()},
     * {@link #resetCounters()}
     */
    public void quiz() {
        askQuestions();
        resultForQuiz();
        displayAnswerStatistic();
        resetCounters();
    }

    /**
     * Метод для формирования массива из вопросов,
     * по-одному передает вопросы в {@link #qenerateQuestion(Question question)},
     * присваиваем значение счетчику общего количества вопросов {@link #countOfQuestions}
     */
    private void askQuestions() {
        Question[] questionsArray = Question.values();
        countOfQuestions = questionsArray.length;
        for (int i = 0; i < questionsArray.length; i++) {
            Question question = Question.values()[i];
            qenerateQuestion(question);
        }
    }

    /**
     * вывод вопроса на экран
     * вызывает {@link #checkPlayerAnswers(Question quesyion)} для обработки ответа пользователя
     * @param question - объект класса Question содержащий вопрос
     */
    private void qenerateQuestion(Question question) {
        question.printQuestion();
        System.out.print("Введите номер ответа - ");

        checkPlayerAnswers(question);
    }

    /**
     * Проверка ответа пользователя на наличие данного варианта в ответах,
     * если есть то вызывается {@link UserAnswersProcessing#saveAnswers(int answer, Question question)}
     * для сохранения ответа в ArrayList
     *
     * @param question - объект класса Question содержащий вопрос
     */
    private void checkPlayerAnswers(Question question) {
        while (true) {
            if (input.hasNextInt()) {
                int playerAnswer = input.nextInt();
                if (playerAnswer > 0 && playerAnswer <= question.answerOptionsLength()) {
                    userAnswersProcessing.saveAnswers(playerAnswer, question);
                    return;
                }
                System.out.println("Такого варианта ответа нет, введите номер ответа еще раз!");
                continue;
            } else {
                System.out.println(input.next() + " - это даже не цифра, давайте попробуем еще раз!");
            }
        }
    }

    /**
     * Вывод количества верных ответов и % успешности в викторине
     */
    private void resultForQuiz() {
        System.out.println("\n Конец!");
        int countOfCorrect = userAnswersProcessing.getCountOfCorrect();
        System.out.println("\nИтого верных ответов - " + countOfCorrect);
        switch (countOfCorrect) {
            case 3:
                System.out.println(playerName + ", отлично, на " + calculatePercentOfTrueAnswers() + "% правильно");
                break;
            case 2:
                System.out.println(playerName + ", хорошо, на " + calculatePercentOfTrueAnswers() + "% правильно");
                break;
            case 1:
                System.out.println(playerName + ", ужасно, на " + calculatePercentOfTrueAnswers() + "% правильно");
                break;
            default:
                System.out.println(playerName + ", не отчаивайтесь");
        }
    }
    /**
     * Возвращает % правильных ответов в викторине
     * @return % правильных ответов
     */
    private int calculatePercentOfTrueAnswers() {
        int countOfAllQuestions = getCountOfQuestions();
        int countOfCorrectAnswers = userAnswersProcessing.getCountOfCorrect();
        return (countOfCorrectAnswers * 100 / countOfAllQuestions);
    }

    /**
     * Запрос на ввод с консоли "S" для отображения правильных и ошибочных ответов (с указанием верных)
     * с помощью вызова {@link UserAnswersProcessing#outputStatisticOfResponses()}
     */
    private void displayAnswerStatistic() {
        System.out.println("\n Введите \"S\" для отображения статистики, либо что угодно для продолжения");
        if (input.next().equalsIgnoreCase("S")){
            userAnswersProcessing.outputStatisticOfResponses();
        }
    }

    /**
     * Обнуляет счетчик правильных ответов и ArrayList со статистикой вызывая
     * {@link UserAnswersProcessing#clearArrayListWithPlayerAnswers()} и
     * {@link UserAnswersProcessing#resetCountOfCorrect()}
     */
    private void resetCounters() {
        userAnswersProcessing.clearArrayListWithPlayerAnswers();
        userAnswersProcessing.resetCountOfCorrect();
    }

    /**
     * @return возвращает общее количество вопросов заданных пользователю
     */
    private int getCountOfQuestions() {
        return countOfQuestions;
    }

    /**
     * Присваивает переменной значение имени пользователя полученное в начале викторины
     * @param playerName - имя пользователя
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

}
