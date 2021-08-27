package com.example.mentalhealthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;


public class Writing extends AppCompatActivity {
    EditText noteTitle, noteDetails;
    Button btnSave;
    JournalDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writing);

        db = new JournalDatabase(this);
        noteTitle = findViewById(R.id.noteTitle);
        noteDetails = findViewById(R.id.noteDetails);
        btnSave=findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Writing.this,"Save Btn Clicked",Toast.LENGTH_SHORT).show();
                int day,month,year;
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                Date date = new Date();
                String x = dateFormat.format(date);
                try {
                    day = Integer.parseInt(x.substring(8, 9));
                    month = Integer.parseInt(x.substring(5, 6));
                    year = Integer.parseInt(x.substring(0, 3));
                    if (!noteTitle.getText().toString().equals("") && !noteDetails.getText().toString().equals("")) {
                        db.addNewJournal(new JournalEntry(noteTitle.getText().toString(),
                                noteDetails.getText().toString(), day, month, year));
                    } else {
                        Toast.makeText(Writing.this, "Fill in the fields",
                                Toast.LENGTH_SHORT).show();
                    }
                    clear();
                    Intent intent = new Intent(Writing.this, JournalActivity.class);
                    startActivity(intent);
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