package com.example.mentalhealthapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class ToDoListActivity extends AppCompatActivity {
   List<String> toDoList;
   ListView listView;
   ArrayAdapter<String> arrayAdapter;
   EditText editText;
   Button b_save,b_load;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);


        toDoList=PrefConfig.readListFromPref(this);
        if(toDoList == null)
          toDoList =new ArrayList<>();

        arrayAdapter =new ArrayAdapter<>(this, R.layout.list_view_layout,toDoList);
        listView = findViewById(R.id.id_list_view);

        listView.setAdapter(arrayAdapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                TextView textView =(TextView ) view;
//                textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
//            }
//        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                final int which_item =position;

                 new AlertDialog.Builder(ToDoListActivity.this)
                .setIcon(android.R.drawable.ic_delete)
                  .setTitle("Are you sure ?")
                         .setMessage("Do you want to delete this item")
                         .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                             @Override
                             public void onClick(DialogInterface dialogInterface, int i) {
                                 toDoList.remove(which_item);
                                 arrayAdapter.notifyDataSetChanged();
                                 PrefConfig.writeListInPref(ToDoListActivity.this,toDoList);
                             }
                         })
                         .setNegativeButton("No",null)
                         .show();

                return true;
            }
        });
        editText =findViewById(R.id.id_edit_text);
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

    public void addItemToList(View view){
        toDoList.add(editText.getText().toString());
        arrayAdapter.notifyDataSetChanged();

        PrefConfig.writeListInPref(getApplicationContext(),toDoList);
        editText.setText("");
    }
}

