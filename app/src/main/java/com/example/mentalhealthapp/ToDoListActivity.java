package com.example.mentalhealthapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class ToDoListActivity extends AppCompatActivity {

    private Button btnNewToDo;
    private RecyclerView recyclerView;
    ArrayList<ToDoItem> items=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);
        recyclerView=findViewById(R.id.recyclerViewToDoList);
        btnNewToDo=findViewById(R.id.btnNewToDoCreate);
        items.add(new ToDoItem("Name","AppName",3));
        ToDoListPreviewAdapter adapter=new ToDoListPreviewAdapter(items);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        btnNewToDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ToDoListActivity.this,"New ToDo Create Option",Toast.LENGTH_SHORT).show();
                //TODO save to db
            }
        });
    }


}