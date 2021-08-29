package com.example.mentalhealthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class screen3 extends AppCompatActivity {
    Button donebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        donebtn=findViewById(R.id.donebtn);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);
        donebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(screen3.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}