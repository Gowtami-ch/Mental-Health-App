package com.example.mentalhealthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class screen3 extends AppCompatActivity {
    FloatingActionButton fab3;
    TextView skip3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);
        skip3=findViewById(R.id.skip3);
        skip3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent skip=new Intent(screen3.this, MainActivity.class);
                startActivity(skip);
            }
        });
        fab3 = findViewById(R.id.fab3);
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(screen3.this, screen4.class);
                startActivity(intent);
            }
        });
    }
}
