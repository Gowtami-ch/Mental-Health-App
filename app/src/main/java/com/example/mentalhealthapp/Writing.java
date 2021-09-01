package com.example.mentalhealthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Writing extends AppCompatActivity {
    private EditText noteTitle, noteDetails;
    private Button btnSave;
    private JournalDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writing);

        db = new JournalDatabase(this);
        noteTitle = findViewById(R.id.jViewTitle);
        noteDetails = findViewById(R.id.jViewContent);
        btnSave=findViewById(R.id.btnSave);

        //Trying to merge Writing and Editing

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(Writing.this, "Save Btn Clicked", Toast.LENGTH_SHORT).show();
                int day, month, year;
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                Date date = new Date();
                String x = dateFormat.format(date);
                try {
                    day = Integer.parseInt(x.substring(8, 10));
                    month = Integer.parseInt(x.substring(5, 7));
                    year = Integer.parseInt(x.substring(0, 4));
                    Toast.makeText(Writing.this, day + "/" + month + "/" + year, Toast.LENGTH_SHORT).show();
                    if (!noteTitle.getText().toString().equals("") && !noteDetails.getText().toString().equals("")) {
                        db.addNewJournal(new JournalEntry(noteTitle.getText().toString(),
                                noteDetails.getText().toString(), day, month, year));
                        clear();
                        Intent intent = new Intent(Writing.this, JournalActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Writing.this, "Fill in the fields",
                                Toast.LENGTH_SHORT).show();
                    }

                } catch (Exception e) {
                    Toast.makeText(Writing.this, "Exception", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void clear(){
        noteDetails.setText("");
        noteTitle.setText("");
    }
}