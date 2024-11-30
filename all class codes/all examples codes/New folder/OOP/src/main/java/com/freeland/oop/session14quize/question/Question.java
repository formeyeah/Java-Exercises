package com.freeland.oop.session14quize.question;

public interface Question {
    String getQuestion();
    String[] getOptions();
    int getCorrectAnswerIndex();
}