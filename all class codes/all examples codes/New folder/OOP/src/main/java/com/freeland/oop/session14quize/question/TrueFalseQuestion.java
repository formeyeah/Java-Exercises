package com.freeland.oop.session14quize.question;

public class TrueFalseQuestion implements Question {
    private String question;
    private boolean correctAnswer;

    public TrueFalseQuestion(String question, boolean correctAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public String[] getOptions() {
        return new String[]{"True", "False"};
    }

    @Override
    public int getCorrectAnswerIndex() {
        return correctAnswer ? 0 : 1; // 0 for True, 1 for False
    }
}