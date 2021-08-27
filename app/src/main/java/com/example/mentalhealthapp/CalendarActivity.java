package com.example.mentalhealthapp;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CalendarActivity extends AppCompatActivity {
    private static final String TAG= "CalendarActivity";
    private CalendarView mcalendarView = (CalendarView ) findViewById(R.id.calendarView);

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.calendar_layout);
        mcalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            public void onSelectedDayChange (CalendarView calendarView ,int i, int i1, int i2 ){
                String date = (i1+1) + "/" + i2 + i;
                Log.d(TAG, "onSelectedDayChange: mm/dd/yyyy" + date);
                Intent intent= new Intent(CalendarActivity.this, CalendarView.class);
                intent.putExtra("date", date);
                startActivity(intent);
            }
        });
    }
}
