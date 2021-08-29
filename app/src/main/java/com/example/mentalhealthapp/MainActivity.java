package com.example.mentalhealthapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mentalhealthapp.model.Cards;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Cards> list = new ArrayList<>();
    MainAdapter adapter;
//    private Button quiz;
//    private Button journal;
//    private Button todolist;
//    private Button profile;
//    private Button news;
//    private Button meme;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String card[] = getResources().getStringArray(R.array.cardtext);
        int profileImage[] = {R.drawable.profile, R.drawable.quiz, R.drawable.news, R.drawable.meme,
        R.drawable.journal, R.drawable.todolist};
        for(int i=0; i<card.length; i++){
            Cards cards = new Cards(profileImage[i],card[i]);
            list.add(cards);
        }
        adapter=new MainAdapter(this,list);
        recyclerView.setAdapter(adapter);
//        quiz=findViewById(R.id.quiz);
//        quiz.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "Working Fine", Toast.LENGTH_SHORT).show();
//                Intent intent=new Intent(MainActivity.this,QuizActivity.class);
//                startActivity(intent);
//            }
//        });
//        journal = findViewById(R.id.journal);
//        journal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "Working Fine", Toast.LENGTH_SHORT).show();
//                Intent intent=new Intent(MainActivity.this,JournalActivity.class);
//                startActivity(intent);
//            }
//        });
//        todolist = findViewById(R.id.todolist);
//        todolist.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "Working Fine", Toast.LENGTH_SHORT).show();
//                Intent intent=new Intent(MainActivity.this,ToDoListActivity.class);
//                startActivity(intent);
//            }
//        });
//        profile = findViewById(R.id.profile);
//        profile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
//                startActivity(intent);
//            }
//        });
//        meme = findViewById(R.id.meme);
//        meme.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, MemeActivity.class);
//                startActivity(intent);
//            }
//        });
//        news = findViewById(R.id.news);
//        news.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, NewsActivity.class);
//                startActivity(intent);
//            }
//        });
    }
}
