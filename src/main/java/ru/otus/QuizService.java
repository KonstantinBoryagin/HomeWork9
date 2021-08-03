package ru.otus;

/**
 * Вспомогательный класс со свойством <b>playerName</b>
 */
public class QuizService {
    private static String playerName;
    //private QuizGenerator quizGenerator = new QuizGenerator();
    private UserAnswersProcessing userAnswersProcessing = new UserAnswersProcessing();

    /**
     * Вывод количества верных ответов и % успешности в викторине
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
     * Возвращает % правильных ответов в викторине
     * @return % правильных ответов
     */
    private int calculatePercentOfTrueAnswers() {
        int countOfAllQuestions = QuizGenerator.getCountOfQuestions();
        int countOfCorrectAnswers = UserAnswersProcessing.getCountOfCorrect();
        return (countOfCorrectAnswers * 100 / countOfAllQuestions);
    }


    /**
     * Присваивает переменной значение имени пользователя полученное в начале викторины
     * @param playerName - имя пользователя
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
