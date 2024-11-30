package com.freeland.oop.session14quize.quize;

import com.freeland.oop.session14quize.question.MultipleChoiceQuestion;
import com.freeland.oop.session14quize.question.Question;
import com.freeland.oop.session14quize.question.TrueFalseQuestion;

public class GeneralKnowledgeQuiz extends BaseQuiz {
    @Override
    protected Question[] getQuestions() {
        return new Question[]{
            new MultipleChoiceQuestion("What is the capital of France?", new String[]{"Berlin", "Madrid", "Paris"}, 2),
            new TrueFalseQuestion("The Earth is flat.", false),
            new MultipleChoiceQuestion("Which planet is known as the Red Planet?", new String[]{"Earth", "Mars", "Jupiter"}, 1)
        };
    }
}