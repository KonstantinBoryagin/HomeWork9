package ru.otus.model;

import java.util.List;

public class Question {
    private int correctAnswer;
    private String question;
    private List<String> answers;

    public Question(int correctAnswer, String question, List<String> answers) {
        this.correctAnswer = correctAnswer;
        this.question = question;
        this.answers = answers;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public String getAnswerForIndex(int index) {
        String answer = answers.get(index);
        return answer;
    }

    public int getAnswersSize() {
        return answers.size();
    }
}
