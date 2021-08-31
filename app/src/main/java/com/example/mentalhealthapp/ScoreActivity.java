package com.example.mentalhealthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.sasank.roundedhorizontalprogress.RoundedHorizontalProgressBar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScoreActivity extends AppCompatActivity {
    TextView tv3;
    Button done;
    QuizDetails quiz;
    QuizDatabase quizDb;
    TextView tvScore;

//    ProgressBar pbc1;
//    ProgressBar pbc2;
//    ProgressBar pbc3;
//    ProgressBar pbc4;
//    ProgressBar pbc5;
//    ProgressBar pbc6;
//    ProgressBar pbc7;
//    ProgressBar pbc8;
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

        int sc=Integer.parseInt(score);
        float sc1=Integer.parseInt(score0);
        float sc2=Integer.parseInt(score1);
        float sc3=Integer.parseInt(score2);
        float sc4=Integer.parseInt(score3);
        float sc5=Integer.parseInt(score4);
        float sc6=Integer.parseInt(score5);
        float sc7=Integer.parseInt(score6);
        float sc8=Integer.parseInt(score7);
        float []arr= {sc1,sc2,sc3,sc4,sc5,sc6,sc7,sc8};

        Date date = new Date();
        DateFormat dtf=new SimpleDateFormat("yyyy/MM/dd");
        String x=dtf.format(date);

        quiz=new QuizDetails(sc,arr,getDateHash(x));
        quizDb=new QuizDatabase(ScoreActivity.this);
        quizDb.addNewQuiz(quiz);

        pbc1 = (RoundedHorizontalProgressBar) findViewById(R.id.pbc1);
        pbc2= (RoundedHorizontalProgressBar) findViewById(R.id.pbc2);
        pbc3= (RoundedHorizontalProgressBar) findViewById(R.id.pbc3);
        pbc4 = (RoundedHorizontalProgressBar) findViewById(R.id.pbc4);
        pbc5 = (RoundedHorizontalProgressBar) findViewById(R.id.pbc5);
        pbc6 = (RoundedHorizontalProgressBar) findViewById(R.id.pbc6);
        pbc7 = (RoundedHorizontalProgressBar) findViewById(R.id.pbc7);
        pbc8 = (RoundedHorizontalProgressBar) findViewById(R.id.pbc8);
        tvScore=findViewById(R.id.txtScoreTotal);

        int scp1=((int)sc1)*100/12;
        int scp2=((int)sc2*100/12),scp3=((int)sc3*100/12),scp4=((int)sc4*100/12),scp5=
                ((int)sc5*100/12),
                scp6= ((int)sc6*100/12),scp7=((int)sc7*100/16),scp8=((int)sc8*100/12);
//        pb1.setProgress(sc);
        pbc1.setProgress(scp1);
        pbc2.setProgress(scp2);
        pbc3.setProgress(scp3);
        pbc4.setProgress(scp4);
        pbc5.setProgress(scp5);
        pbc6.setProgress(scp6);
        pbc7.setProgress(scp7);
        pbc8.setProgress(scp8);

        pbc1.setProgressColors(Color.parseColor("#ffedbc"),Color.parseColor("#514a9d"));
        pbc2.setProgressColors(Color.parseColor("#ffedbc"),Color.parseColor("#514a9d"));
        pbc3.setProgressColors(Color.parseColor("#ffedbc"),Color.parseColor("#514a9d"));
        pbc4.setProgressColors(Color.parseColor("#ffedbc"),Color.parseColor("#514a9d"));
        pbc5.setProgressColors(Color.parseColor("#ffedbc"),Color.parseColor("#514a9d"));
        pbc6.setProgressColors(Color.parseColor("#ffedbc"),Color.parseColor("#514a9d"));
        pbc7.setProgressColors(Color.parseColor("#ffedbc"),Color.parseColor("#514a9d"));
        pbc8.setProgressColors(Color.parseColor("#ffedbc"),Color.parseColor("#514a9d"));


//        pb1.animateProgress(1000,0,sc);
        pbc1.animateProgress(1000,0,scp1);
        pbc2.animateProgress(1000,0,scp2);
        pbc3.animateProgress(1000,0,scp3);
        pbc4.animateProgress(1000,0,scp4);
        pbc5.animateProgress(1000,0,scp5);
        pbc6.animateProgress(1000,0,scp6);
        pbc7.animateProgress(1000,0,scp7);
        pbc8.animateProgress(1000,0,scp8);
       done = findViewById(R.id.done);
        tv3 = findViewById(R.id.tv3);
        String status;
        if(sc>=0&&sc<20)
          status="Very Low";
        else if(sc>=20&&sc<40)
           status="Low";
        else if(sc>=40&&sc<60)
            status="Moderate";
        else if(sc>=60&&sc<80)
            status="High";
        else
            status="Very High";
         tv3.setText(status);
         tvScore.setText(sc+"");

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ScoreActivity.this,MainActivity.class);
                intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK |intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }

    private int getDateHash(String x){
        int day,month,year;
        try{
            day = Integer.parseInt(x.substring(8, 10));
            month = Integer.parseInt(x.substring(5, 7));
            year = Integer.parseInt(x.substring(0, 4));
            return year*31*12 + month*31 + day;
        }
        catch(Exception e){
            return -1;
        }
    }
}
