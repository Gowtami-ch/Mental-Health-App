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

public class quizStatistics extends AppCompatActivity {

    BarChart barChart;
    ArrayList<QuizDetails> quizDetails=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_statistics);

        barChart=findViewById(R.id.barGraph);
        barChart.setNoDataText("You Have Taken No Quizzes:(");
        barChart.setLogEnabled(false);

        ArrayList<BarEntry> barEntries=new ArrayList<>();
        barEntries.add(new BarEntry(2001,20));
        barEntries.add(new BarEntry(2002,40));
        barEntries.add(new BarEntry(2003,40));
        barEntries.add(new BarEntry(2004,40));
        barEntries.add(new BarEntry(2005,40));
        barEntries.add(new BarEntry(2006,40));
        barEntries.add(new BarEntry(2007,40));
        barEntries.add(new BarEntry(2008,40));
        barEntries.add(new BarEntry(2009,40));

        BarDataSet barDataSet=new BarDataSet(barEntries,"Your Quiz Statistics!!!");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);

        BarData barData=new BarData(barDataSet);


        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.getDescription().setText("Bar Chart For Quiz Activity");
        barChart.animateY(2000);

    }
}