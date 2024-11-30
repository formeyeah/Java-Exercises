package com.freeland.oop.session14quize.quize;
import java.util.Scanner;

import com.freeland.oop.session14quize.question.Question;

public abstract class BaseQuiz implements Quiz {
    protected abstract Question[] getQuestions();

    @Override
    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        Question[] questions = getQuestions();
        int score = 0;

        for (Question question : questions) {
            System.out.println(question.getQuestion());
            String[] options = question.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }

            System.out.print("Your answer (1-" + options.length + "): ");
            int answer = scanner.nextInt() - 1; // Convert to zero-based index

            if (answer == question.getCorrectAnswerIndex()) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer is: " + options[question.getCorrectAnswerIndex()]);
            }
            System.out.println();
        }

        System.out.println("Your total score: " + score + "/" + questions.length);
        scanner.close();
    }
}