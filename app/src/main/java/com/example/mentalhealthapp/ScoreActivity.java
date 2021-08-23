package com.example.mentalhealthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {
    TextView tv3;
    Button done;
    TextView scoretext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        tv3 = findViewById(R.id.tv3);
        done = findViewById(R.id.done);
        scoretext=findViewById(R.id.scoretext);
        Intent intent = getIntent();
        String score = intent.getStringExtra(QuizActivity.EXTRA_SCORE);
        tv3.setText(score);
        String status="";
        int sc=Integer.parseInt(score);
        if(sc>=0&&sc<15)
          status="Low";
        else if(sc>=15&&sc<25)
           status="Moderate";
        else if(sc>=25&&sc<35)
            status="High";
        else
            status="Very High";
         scoretext.setText(score+"\n"+status);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ScoreActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
