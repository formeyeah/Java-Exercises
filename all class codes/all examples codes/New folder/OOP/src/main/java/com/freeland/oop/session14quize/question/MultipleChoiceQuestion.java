package com.freeland.oop.session14quize.question;

public class MultipleChoiceQuestion implements Question {
    private String question;
    private String[] options;
    private int correctAnswerIndex;

    public MultipleChoiceQuestion(String question, String[] options, int correctAnswerIndex) {
        this.question = question;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public String[] getOptions() {
        return options;
    }

    @Override
    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}