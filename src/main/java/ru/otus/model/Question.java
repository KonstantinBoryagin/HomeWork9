package ru.otus.model;

import java.util.List;

public class Question {
    private int trueAnswer;
    private String question;
    private List<String> answers;

    public Question(int trueAnswer, String question, List<String> answers) {
        this.trueAnswer = trueAnswer;
        this.question = question;
        this.answers = answers;
    }

    public int getTrueAnswer() {
        return trueAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getAnswers() {
        return answers;
    }
}
