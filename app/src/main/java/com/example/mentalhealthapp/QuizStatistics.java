package com.example.mentalhealthapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class QuizStatistics extends AppCompatActivity {

    BarChart barChart;
    ArrayList<QuizDetails> quizDetails=new ArrayList<>();
    QuizDatabase quizDb;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_statistics);

        quizDb=new QuizDatabase(QuizStatistics.this);
        quizDetails=quizDb.getQuizEntries();
        dialog = new Dialog(QuizStatistics.this);

        barChart=findViewById(R.id.barGraph);
        barChart.setNoDataText("You Have Taken No Quizzes:(");
        barChart.setLogEnabled(false);

        ArrayList<BarEntry> barEntries=new ArrayList<>();
//        barEntries.add(new BarEntry(2001,20));

        
        for(int i=0;i<quizDetails.size();i++){
            float []arr=quizDetails.get(i).getCategoryScores();
            barEntries.add(new BarEntry(i,arr));
        }

        String[] labels={"well-being and ill-being", "physical health" , "control, autonomy and " +
                "choice", "self-perception", "relationships and belonging", " activity",
                "hope and hopelessness","Stress and Anxiety"};

        int [] colors={Color.parseColor("#A52A2A"),Color.parseColor("#FF018786"),
                Color.GRAY,
                Color.parseColor("#7B68EE"),Color.parseColor("#2E7DBC"),
                Color.CYAN,
                Color.YELLOW,Color.parseColor("#FF7F50")};

        BarDataSet barDataSet=new BarDataSet(barEntries,"");
        barDataSet.setColors(colors);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(8f);
        barDataSet.setStackLabels(labels);
        BarData barData=new BarData(barDataSet);

        YAxis yAxis=barChart.getAxisLeft();
        YAxis yAxisRight=barChart.getAxisRight();
        yAxis.setAxisMinimum(0);
        yAxisRight.setAxisMinimum(0);

        if(quizDetails.size()<5){
            XAxis xAxis=barChart.getXAxis();
            xAxis.setAxisMaximum(5);
            barChart.setScaleMinima(1f, 1.5f);
        }
        else {
            barChart.setScaleMinima((float) quizDetails.size() / (float) 5, 1.5f);
        }




        barChart.setDragEnabled(true);
        barChart.setScaleXEnabled(false);
        barChart.setFitBars(false);

        //DataSet Added to Bar Chart
        barChart.setData(barData);

        barChart.getDescription().setEnabled(false);
        Legend l = barChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setFormSize(9f);
        l.setFormToTextSpace(4f);
        l.setXEntrySpace(6f);
        l.setWordWrapEnabled(true);
        barChart.animateY(1000);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.explanation,menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.Explanation:
                Button btnClose;
                dialog.setContentView(R.layout.stats_description);
                dialog.show();
                btnClose = dialog.findViewById(R.id.close3);

                btnClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}