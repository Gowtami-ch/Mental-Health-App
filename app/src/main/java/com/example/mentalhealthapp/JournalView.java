package com.example.mentalhealthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class JournalView extends AppCompatActivity {
    TextView title,content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_view);
        //TODO MAYBE ADD A MENU FOR EDIT AND DELETE..
        title=findViewById(R.id.jViewTitle);
        content=findViewById(R.id.jViewContent);
        Intent intent=getIntent();
        title.setText(intent.getStringExtra("title"));
        content.setText(intent.getStringExtra("content"));
    }
}