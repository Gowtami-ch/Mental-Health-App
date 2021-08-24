package com.example.mentalhealthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class JournalActivity extends AppCompatActivity {

    private FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal);
        fab=findViewById(R.id.fabActJournal);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(JournalActivity.this,"Go to Writing Activity",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(JournalActivity.this,Writing.class);
                startActivity(intent);
            }
        });

    }
}