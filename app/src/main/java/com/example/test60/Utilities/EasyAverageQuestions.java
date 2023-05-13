package com.example.test60.Utilities;

public class EasyAverageQuestions {
    private String question;
    private String correctAnswer;
    private String choice1;
    private String choice2;
    private String choice3;

    public EasyAverageQuestions(String question, String correctAnswer, String choice1, String choice2, String choice3) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }
}
