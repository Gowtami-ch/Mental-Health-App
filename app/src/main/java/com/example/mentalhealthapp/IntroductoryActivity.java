package com.example.mentalhealthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class IntroductoryActivity extends AppCompatActivity
{
    ImageView pinkbg;
    LottieAnimationView lottie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introductory);
        pinkbg=findViewById(R.id.pinkbg);
        lottie=findViewById(R.id.lottie);
        pinkbg.animate().translationY(-1600).setDuration(1000).setStartDelay(4000);
        lottie.animate().translationY(1400).setDuration(1000).setStartDelay(4000);
//        Intent intent=new Intent(IntroductoryActivity.this,MainActivity.class);
//        startActivity(intent);
    }
}