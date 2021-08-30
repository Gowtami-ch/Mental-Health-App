package com.example.mentalhealthapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    private Button btnEdit,btnBack;
    private TextView tvName,tvBio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        btnBack=findViewById(R.id.btnProfileBack);
        btnEdit=findViewById(R.id.btnProfileEdit);
        tvName=findViewById(R.id.tvNameProfile);
        tvBio=findViewById(R.id.tvBioProfile);
        
        SharedPreferences sharedPreferences=
                PreferenceManager.getDefaultSharedPreferences(ProfileActivity.this);
        try{
            String TEXT1 = sharedPreferences.getString("TEXT", "Default");
            tvName.setText(TEXT1);
            Toast.makeText(ProfileActivity.this,"Got Prefs",Toast.LENGTH_SHORT).show();
            String txtBio = sharedPreferences.getString("bio", "One");
            tvBio.setText(txtBio);
        }
        catch(Exception e){

        }

//        String Text1 =sharedPreferences.getString("Text","");
//        nPassword.setText(Text1);
//
//        Bundle bn=getIntent().getExtras();
//        Bundle bn1=getIntent().getExtras();



        ActivityResultLauncher<Intent> launchSomeActivity = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK){
                            Intent data=result.getData();
                            String Name = data.getStringExtra("Name");
                            String Bio = data.getStringExtra("Bio");
                            tvName.setText(String.valueOf(Name));
                            tvBio.setText(String.valueOf(Bio));
                        }
                    }
                });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(ProfileActivity.this,ProfileEditActivity.class);
                intent.putExtra("Name",tvName.getText().toString());
                intent.putExtra("Bio",tvBio.getText().toString());
                launchSomeActivity.launch(intent);
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
        SharedPreferences sharedPreferences=
                PreferenceManager.getDefaultSharedPreferences(ProfileActivity.this);

        SharedPreferences.Editor editor =sharedPreferences.edit();
        editor.putString("TEXT", tvName.getText().toString());
        editor.putString("bio", tvBio.getText().toString());
//        editor.putString("Text", Text);
        editor.apply();

        Toast.makeText(ProfileActivity.this,"Finish Activity",Toast.LENGTH_SHORT).show();

        Intent intent=new Intent(ProfileActivity.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}