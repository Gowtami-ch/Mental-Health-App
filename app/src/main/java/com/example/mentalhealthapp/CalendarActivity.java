package com.example.mentalhealthapp;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CalendarActivity extends AppCompatActivity {
    private static final String TAG= "CalendarActivity";
    private CalendarView mCalendarView;
    private RecyclerView recyclerView;
    private TextView hiddenTxt;
    JournalDatabase db;
    //TODO filter complete arrayList wrt to Date and store below for recycler!!
    ArrayList<JournalEntry> filtered=new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_layout);
        //Today's Preview
        //put Arraylist completeJournalEntries;
        db=new JournalDatabase(CalendarActivity.this);

        mCalendarView = (CalendarView) findViewById(R.id.calendarView);
        recyclerView = findViewById(R.id.recyclerViewCalendar);
        hiddenTxt=findViewById(R.id.txtViewHidden);
        filtered =db.getJournalEntries();
        JournalPreviewAdapter adapter=new JournalPreviewAdapter(filtered,CalendarActivity.this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true));
        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            public void onSelectedDayChange (CalendarView calendarView ,int i, int i1, int i2 ){
                String date = (i1+1) + "/" + i2 + i;
                Log.d(TAG, "onSelectedDayChange: mm/dd/yyyy " + date);
                //TODO filtering based on JournalEntry Class Attributes -> Need Database
                filtered.clear();
                filtered= db.getFilteredJournalEntries(i2,i1+1,i);
                if(filtered.size()>0){
                    hiddenTxt.setVisibility(View.GONE);
                }
                else{
                    hiddenTxt.setVisibility(View.VISIBLE);
                }
                adapter.setJournalEntries(filtered);
            }
        });
    }

    @Override
    public void finish(){
        Intent intent=new Intent(CalendarActivity.this,JournalActivity.class);
        startActivity(intent);
    }
}
