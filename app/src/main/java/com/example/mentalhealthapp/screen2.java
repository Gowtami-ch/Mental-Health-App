package com.example.mentalhealthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class screen2 extends AppCompatActivity {
    FloatingActionButton fab2;
    TextView skip2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);
        skip2=findViewById(R.id.skip2);
        skip2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent skip=new Intent(screen2.this, MainActivity.class);
                startActivity(skip);
            }
        });
        fab2 = findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(screen2.this, screen3.class);
                startActivity(intent);
            }
        });
    }
}
