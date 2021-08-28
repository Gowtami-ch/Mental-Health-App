package com.example.mentalhealthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class JournalEditing extends AppCompatActivity {

    private EditText noteTitle, noteDetails;
    private Button btnSaveEdit;
    private JournalDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_editing);

        db = new JournalDatabase(this);
        noteTitle = findViewById(R.id.jViewTitleEdit);
        noteDetails = findViewById(R.id.jViewContentEdit);
        btnSaveEdit=findViewById(R.id.btnSaveEdit);

        noteDetails.setText(getIntent().getStringExtra("content"));
        noteTitle.setText(getIntent().getStringExtra("title"));
        btnSaveEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(JournalEditing.this,"Made It",Toast.LENGTH_SHORT).show();
                Intent intent=getIntent();
                JournalEntry j=new JournalEntry(intent.getStringExtra("title"),
                        intent.getStringExtra("content"),intent.getIntExtra("day",-1),
                        intent.getIntExtra("month",-1),intent.getIntExtra("year",-1));
                boolean b = db.updateJournal(j,intent.getIntExtra("id",-1));
                Toast.makeText(JournalEditing.this,"Editsuccess="+b,Toast.LENGTH_SHORT).show();
            }
        });
    }
}