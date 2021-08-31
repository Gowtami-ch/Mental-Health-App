package com.example.mentalhealthapp;

public class QuizDetails {
    private int quizScoreTotal;
    private float[] categoryScores;
    private int quizDateHash;

    public QuizDetails(int quizScoreTotal, float[] categoryScores, int quizDateHash) {
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

    public float[] getCategoryScores() {
        return categoryScores;
    }

    public void setCategoryScores(float[] categoryScores) {
        this.categoryScores = categoryScores;
    }

    public int getQuizDateHash() {
        return quizDateHash;
    }

    public void setQuizDateHash(int quizDateHash) {
        this.quizDateHash = quizDateHash;
    }
}
