package com.example.mentalhealthapp;

public class QuizDetails {
    private int quizScoreTotal;
    private int[] categoryScores;
    private int quizDateHash;

    public QuizDetails(int quizScoreTotal, int[] categoryScores, int quizDateHash) {
        this.quizScoreTotal = quizScoreTotal;
        this.categoryScores = categoryScores;
        this.quizDateHash = quizDateHash;
    }

    public int getQuizScoreTotal() {
        return quizScoreTotal;
    }

    public void setQuizScoreTotal(int quizScoreTotal) {
        this.quizScoreTotal = quizScoreTotal;
    }

    public int[] getCategoryScores() {
        return categoryScores;
    }

    public void setCategoryScores(int[] categoryScores) {
        this.categoryScores = categoryScores;
    }

    public int getQuizDateHash() {
        return quizDateHash;
    }

    public void setQuizDateHash(int quizDateHash) {
        this.quizDateHash = quizDateHash;
    }
}
