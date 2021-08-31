package com.example.mentalhealthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class screen4 extends AppCompatActivity {
    FloatingActionButton fab4;
    TextView skip4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen4);
        skip4=findViewById(R.id.skip4);
        skip4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent skip=new Intent(screen4.this, MainActivity.class);
                startActivity(skip);
            }
        });
        fab4 = findViewById(R.id.fab4);
        fab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(screen4.this, screen5.class);
                startActivity(intent);
            }
        });
    }
}