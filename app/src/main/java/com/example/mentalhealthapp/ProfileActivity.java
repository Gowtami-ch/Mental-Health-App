package com.example.mentalhealthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private Button btnEdit,btnBack;
    private TextView tvName,tvBio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        TextView Display1 = findViewById(R.id.tvNameProfile);
        TextView Display2 = findViewById(R.id.tvBioProfile);
        Bundle bn=getIntent().getExtras();
        Bundle bn1=getIntent().getExtras();
        String Name =bn1.getString("txt");
        String name =bn.getString("TEXT");
        Display1.setText(String.valueOf(name));
        Display2.setText(String.valueOf(Name));

        btnBack=findViewById(R.id.btnProfileBack);
        btnEdit=findViewById(R.id.btnProfileEdit);
        tvName=findViewById(R.id.tvNameProfile);
        tvBio=findViewById(R.id.tvBioProfile);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(ProfileActivity.this,ProfileEditActivity.class);
                intent.putExtra("Name",tvName.getText().toString());
                intent.putExtra("Bio",tvBio.getText().toString());
                startActivity(intent);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void finish(){
        Intent intent=new Intent(ProfileActivity.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}