package com.example.mentalhealthapp;

import static android.service.controls.ControlsProviderService.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sasank.roundedhorizontalprogress.RoundedHorizontalProgressBar;

public class ScoreActivity extends AppCompatActivity {
    TextView tv3;
    Button done;
    RoundedHorizontalProgressBar pb1;
    RoundedHorizontalProgressBar pbc1;
    RoundedHorizontalProgressBar pbc2;
    RoundedHorizontalProgressBar pbc3;
    RoundedHorizontalProgressBar pbc4;
    RoundedHorizontalProgressBar pbc5;
    RoundedHorizontalProgressBar pbc6;
    RoundedHorizontalProgressBar pbc7;
    RoundedHorizontalProgressBar pbc8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        Intent intent = getIntent();
        String score = intent.getStringExtra(QuizActivity.EXTRA_SCORE), score0 = intent.getStringExtra(QuizActivity.EXTRA_SCORE_0),score1=intent.getStringExtra(QuizActivity.EXTRA_SCORE_1), score2 = intent.getStringExtra(QuizActivity.EXTRA_SCORE_2),
                score3 = intent.getStringExtra(QuizActivity.EXTRA_SCORE_3), score4 = intent.getStringExtra(QuizActivity.EXTRA_SCORE_4), score5 = intent.getStringExtra(QuizActivity.EXTRA_SCORE_5),
                score6 = intent.getStringExtra(QuizActivity.EXTRA_SCORE_6), score7 = intent.getStringExtra(QuizActivity.EXTRA_SCORE_7);
        System.out.println(score0+" "+score1+" "+score2+" "+score3+" "+score4+" "+score5+" "+score6+" "+score7+" ");
//        String score1="";
//        String score2="";
//        String score3="";
//        String score4="";
//        String score5="";
//        String score6="";
//        String score7="";
//        String score8="";
        int sc=Integer.parseInt(score);
//        int sc1=Integer.parseInt(score1);
//        int sc2=Integer.parseInt(score2);
//        int sc3=Integer.parseInt(score3);
//        int sc4=Integer.parseInt(score4);
//        int sc5=Integer.parseInt(score5);
//        int sc6=Integer.parseInt(score6);
//        int sc7=Integer.parseInt(score7);
//        int sc8=Integer.parseInt(score8);
        pb1 = (RoundedHorizontalProgressBar) findViewById(R.id.pb1);
//        pbc1 = (RoundedHorizontalProgressBar) findViewById(R.id.pbc1);
//        pbc2= (RoundedHorizontalProgressBar) findViewById(R.id.pbc2);
//        pbc3= (RoundedHorizontalProgressBar) findViewById(R.id.pbc3);
//        pbc4 = (RoundedHorizontalProgressBar) findViewById(R.id.pbc4);
//        pbc5 = (RoundedHorizontalProgressBar) findViewById(R.id.pbc5);
//        pbc6 = (RoundedHorizontalProgressBar) findViewById(R.id.pbc6);
//        pbc7 = (RoundedHorizontalProgressBar) findViewById(R.id.pbc7);
//        pbc8 = (RoundedHorizontalProgressBar) findViewById(R.id.pbc8);
        pb1.setProgress(sc);
//        pbc1.setProgress(sc1);
//        pbc2.setProgress(sc2);
//        pbc3.setProgress(sc3);
//        pbc4.setProgress(sc4);
//        pbc5.setProgress(sc5);
//        pbc6.setProgress(sc6);
//        pbc7.setProgress(sc7);
//        pbc8.setProgress(sc8);
        pb1.animateProgress(1000,0,sc);
//        pbc1.animateProgress(1000,0,sc1);
//        pbc2.animateProgress(1000,0,sc2);
//        pbc3.animateProgress(1000,0,sc3);
//        pbc4.animateProgress(1000,0,sc4);
//        pbc5.animateProgress(1000,0,sc5);
//        pbc6.animateProgress(1000,0,sc6);
//        pbc7.animateProgress(1000,0,sc7);
//        pbc8.animateProgress(1000,0,sc8);
       done = findViewById(R.id.done);
        tv3 = findViewById(R.id.tv3);
        String status="";
        if(sc>=0&&sc<15)
          status="Very Low";
        else if(sc>=15&&sc<25)
           status="Low";
        else if(sc>=25&&sc<35)
            status="Moderate";
        else if(sc>=35&&sc<50)
            status="High";
        else
            status="Very High";
         tv3.setText(status);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ScoreActivity.this,MainActivity.class);
                intent.setFlags( intent.FLAG_ACTIVITY_NEW_TASK |intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }
}
