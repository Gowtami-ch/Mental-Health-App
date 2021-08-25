package com.example.mentalhealthapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class JournalActivity extends AppCompatActivity {

    private FloatingActionButton fabActJournal,fabCalendar;
    RecyclerView journalRec;
    ArrayList<JournalEntry> journalEntries=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal);
        fabActJournal=findViewById(R.id.fabActJournal);
        journalRec=findViewById(R.id.recyclerViewJournalMain);
        fabActJournal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(JournalActivity.this,"Go to Writing Activity",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(JournalActivity.this,Writing.class);
                startActivity(intent);
            }
        });
        fabCalendar=findViewById(R.id.fabCalendar);
        fabCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(JournalActivity.this,"Go to Calendar Activity",Toast.LENGTH_SHORT).show();
            }
        });
        journalEntries.add(new JournalEntry("Diary1","This is my Diary"));
        journalEntries.add(new JournalEntry("Diary2","This is my 2nd Diary"));
        journalEntries.add(new JournalEntry("Diary3","This is my 3rd Diary"));
        JournalPreviewAdapter adapter=new JournalPreviewAdapter(journalEntries);
        journalRec.setAdapter(adapter);
//        journalRec.setLayoutManager(new LinearLayoutManager(this));
        journalRec.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true));

    }
}