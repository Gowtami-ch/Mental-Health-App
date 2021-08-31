package com.example.mentalhealthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class QuizStatistics extends AppCompatActivity {

    BarChart barChart;
    ArrayList<QuizDetails> quizDetails=new ArrayList<>();
    QuizDatabase quizDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_statistics);

        quizDb=new QuizDatabase(QuizStatistics.this);
        quizDetails=quizDb.getQuizEntries();

        barChart=findViewById(R.id.barGraph);
        barChart.setNoDataText("You Have Taken No Quizzes:(");
        barChart.setLogEnabled(false);

        ArrayList<BarEntry> barEntries=new ArrayList<>();
//        barEntries.add(new BarEntry(2001,20));

        for(int i=0;i<quizDetails.size();i++){
            barEntries.add(new BarEntry(i,quizDetails.get(i).getQuizScoreTotal()));
        }


        BarDataSet barDataSet=new BarDataSet(barEntries,"Your Quiz Statistics!!!");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);

        BarData barData=new BarData(barDataSet);


//        barChart.setFitBars(false);
        barChart.setData(barData);
        barChart.getDescription().setText("Bar Chart For Quiz Activity");
        barChart.animateY(4000);

    }
}