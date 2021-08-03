package ru.otus;

import java.util.Scanner;

/**
 * Класс создания Викторины
 */
public class QuizGenerator {
    /** Поле - общее количество вопросов заданных пользователю*/
    private static int countOfQuestions;
    private final Scanner input = new Scanner(System.in);
    private final UserAnswersProcessing userAnswersProcessing = new UserAnswersProcessing();
    private final QuizService quizService = new QuizService();

    public Scanner getInput() {
        return input;
    }

    /**
     * Метод для пошагового выполнения викторины
     * {@link #askQuestions()}
     * {@link #resultForQuiz()}
     * {@link #displayAnswerStatistic()}
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
     * инкриминирует счетчик общего количества вопросов {@link #countOfQuestions}
     */
    private void askQuestions() {
        Question[] questionsArray = Question.values();
        for (int i = 0; i < questionsArray.length; i++) {
            Question question = Question.values()[i];
            qenerateQuestion(question);
            countOfQuestions++;
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
     * Вызов {@link QuizService#resultOfGame()} для отображения количества верных ответов
     */
    private void resultForQuiz() {
        System.out.println("\n Конец!");
        quizService.resultOfGame();
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
     * Обнуление счетчика правильных ответов и ArrayList со статистикой вызывая
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
    public static int getCountOfQuestions() {
        return countOfQuestions;
    }
}
