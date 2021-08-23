package com.example.mentalhealthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {
    TextView tv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        tv3 = findViewById(R.id.tv3);
        Intent intent = getIntent();
        String score = intent.getStringExtra(QuizActivity.EXTRA_SCORE);
        tv3.setText(score);

    }
}