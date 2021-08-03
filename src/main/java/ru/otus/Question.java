package ru.otus;

/**
 * enum в котором создаются вопросы для викторины со свойствами <b>correct</b>, <b>question</b> и <b>String[]</b>
 */
public enum Question {
    QUESTION_ONE (3, "Сколько примитивных типов данных в Java?",
            new String[] {"Десять", "Пять", "Восемь"}),
    QUESTION_TWO (4, "Какой из советских фильмов получил Оскар?",
            new String[] {"Кин-Дза-Дза","Сталкер", "Солярис", "Москва слезам не верит"}),
    QUESTION_THREE (1, "Чем является Milky Way",
            new String[] {"Галактика", "Скопление звёзд", "Парад планет", "Солнечная система", "Шоколодка"});

    /** Поле праввильный ответ*/
    private final int correctAnswer;
    /** Поле вопрос*/
    private final String question;
    /** Поле варианты ответов*/
    private final String[] answerOptions;

    /**
     * Конструктор создания нового вопроса для викторины
     * @param correctAnswer - номер правильного ответа
     * @param question - вопрос
     * @param answerOptions - массив с вариантами ответов
     */
    Question (int correctAnswer, String question, String[] answerOptions) {
        this.correctAnswer = correctAnswer;
        this.question = question;
        this.answerOptions = answerOptions;
    }

    /**
     * Метод для вывода вариантов ответов (в 2 столбца)
     */
    public void printQuestion() {
        System.out.println("\n" + question);
        int formatOutput = 0;
        for (int i = 0; i < answerOptions.length; i++) {
            System.out.printf("%3d"+ ". " + "%-20s", (i + 1), answerOptions[i]);
            formatOutput++;
            if (formatOutput % 2 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    /**
     * @return возвращает размер массива с вариантами ответов
     */
    public int answerOptionsLength() {
        return answerOptions.length;
    }

    /**
     * @return возвращает правильный ответ на вопрос
     */
    public int getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * @return возвращает массив с вариантами ответа на вопрос
     */
    public String[] getAnswerOptions() {
        return answerOptions;
    }
}
