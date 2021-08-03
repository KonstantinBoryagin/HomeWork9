package ru.otus;

public class QuizService {
    private static String playerName;
    //private QuizGenerator quizGenerator = new QuizGenerator();
    private UserAnswersProcessing userAnswersProcessing = new UserAnswersProcessing();

    /**
     * Вывод количества верных ответов и % успешности в векторине
     */
    public void resultOfGame() {
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
     * @return возвращает % правильных ответов за игру
     */
    private int calculatePercentOfTrueAnswers() {
        int countOfAllAnswers = QuizGenerator.getCountOfQuestions();
        int countOfCorrectAnswers = userAnswersProcessing.getCountOfCorrect();
        int percentOfTruAnswers = (countOfCorrectAnswers * 100) / countOfAllAnswers;
        return percentOfTruAnswers;
    }


    /**
     * Присваивает переменной значение имени пользователя полученное в начале викторины
     * @param playerName - имя пользователя
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
