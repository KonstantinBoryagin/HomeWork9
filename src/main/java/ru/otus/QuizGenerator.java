package ru.otus;

import ru.otus.model.Question;

import java.util.List;
import java.util.Scanner;

/**
 * Класс создания Викторины
 */
public class QuizGenerator {

    /** Поле - имя пользователя, задается в методе {@link #setPlayerName(String)} */
    private String playerName;
    private final Scanner input = new Scanner(System.in);
    private final UserAnswersProcessing userAnswersProcessing = new UserAnswersProcessing();
    private final QuestionGenerator questionGenerator = new QuestionGenerator();

    public Scanner getInput() {
        return input;
    }

    /**
     * Метод для пошагового выполнения викторины с помощью вызовов
     * {@link #processingQuiz()},
     * {@link #resultForQuiz()},
     * {@link #displayAnswerStatistic()},
     * {@link #resetCounters()}
     */
    public void quiz() {
        processingQuiz();
        resultForQuiz();
        displayAnswerStatistic();
        resetCounters();
    }

    /**
     * Метод получает массив вопросов из {@link QuestionGenerator#formListOfQuestions()}
     * по-одному передает вопросы в {@link #processingQuestions(Question question)}
     */
    private void processingQuiz() {
        List<Question> questions = questionGenerator.formListOfQuestions();

        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            processingQuestions(question);
        }
    }

    /**
     * Печатает вопрос на экран {@link QuestionGenerator#printQuestion(Question)},
     * обрабатывает ответ пользователя {@link #checkPlayerAnswers(Question)}
     * @param question - объект Question содержащий вопрос и варианты ответа
     */
    private void processingQuestions(Question question) {
        questionGenerator.printQuestion(question);
        checkPlayerAnswers(question);
    }

    /**
     * Проверка ответа пользователя на наличие данного варианта в ответах,
     * если есть то вызывается {@link UserAnswersProcessing#saveAnswers(int answer, Question question)}
     * для сохранения ответа в ArrayList
     *
     * @param question - объект класса Question содержащий вопрос и варианты ответа
     */
    private void checkPlayerAnswers(Question question) {
        while (true) {
            if (input.hasNextInt()) {
                int playerAnswer = input.nextInt();
                int size = question.getAnswersSize();
                if (playerAnswer > 0 && playerAnswer <= size) {
                    userAnswersProcessing.saveAnswers(playerAnswer, question);
                    return;
                }
                System.out.println("Такого варианта ответа нет, введите номер ответа еще раз!");
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
        int countOfCorrect = userAnswersProcessing.getCountOfCorrectAnswers();
        System.out.println("\nИтого верных ответов - " + countOfCorrect);
        System.out.println(playerName + ", отлично, на " + calculatePercentOfTrueAnswers() + "% правильно");
    }

    /**
     * Возвращает % правильных ответов в викторине
     * @return % правильных ответов
     */
    private int calculatePercentOfTrueAnswers() {
        int countOfAllQuestions = questionGenerator.getCountOfQuestions();
        int countOfCorrectAnswers = userAnswersProcessing.getCountOfCorrectAnswers();
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
     * Присваивает переменной значение имени пользователя полученное в начале викторины
     * @param playerName - имя пользователя
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

}
