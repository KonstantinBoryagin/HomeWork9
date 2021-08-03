package ru.otus;

/**
 * "Викторина"
 * @author Konstantin Boryagin
 * @version 1.0
 */
public class Quiz {
    private static QuizGenerator quizGenerator;
    private static QuizService quizService;

    private static void init(){
        quizGenerator = new QuizGenerator();
        quizService = new QuizService();
    }


    public static void main(String[] args) {

        /**Инициализация объектов классов QuizGenerator и QuizService */
        init();

        System.out.println("Добро пожаловать! Введите Ваше имя что бы начать!");

        /** Получаем и записываем имя пользователя в {@link QuizService#setPlayerName(String name)} */
        quizService.setPlayerName(quizGenerator.getInput().nextLine());

        /**
         * Вызываем метод пошагового выполнения викторины {@link QuizGenerator#quiz()}
         * пока не будет введена "Q" для выхода из программы
         */
        while (true) {
            quizGenerator.quiz();

            System.out.println("\n Что бы выйти введите \"Q\" или что либо другое для повтора");

            if (quizGenerator.getInput().next().equalsIgnoreCase("q")) {
                return;
            } else {
                System.out.println("Начнем заново!");
            }
        }
    }
}
