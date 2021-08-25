package com.example.mentalhealthapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalendarView extends AppCompatActivity {

    private static final String TAG = "CalendarView";

    private TextView mDisplayDate;
    private Button btnGoCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_view);
        mDisplayDate = ( TextView ) findViewById(R.id.Date);
        btnGoCalendar = ( Button ) findViewById(R.id.btnGoCalendar);
        Intent incomingIntent =getIntent();
        String date= incomingIntent.getStringExtra("date");
        mDisplayDate.setText(date);
        btnGoCalendar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(CalendarView.this, CalendarActivity.class);
                startActivity(intent);


            }


        });
    }


}


