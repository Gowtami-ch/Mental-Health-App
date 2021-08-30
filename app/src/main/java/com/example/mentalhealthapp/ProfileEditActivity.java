package com.example.mentalhealthapp;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URI;

public class ProfileEditActivity extends AppCompatActivity {

    public Button btnSave;
    public TextView nText;
    public EditText nName;
    public EditText nBio;
    public EditText nPassword;
    public ImageView profileImage;
   // public String getString;
    public  String TEXT ,txt, Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);
        btnSave = (Button)findViewById(R.id.btnProfileSave);

        nText = (TextView ) findViewById(R.id.id_edit_text);
        nName = (EditText ) findViewById(R.id.tvNameProfile);
        nBio = (EditText ) findViewById(R.id.tvBioProfile);
        nPassword =(EditText ) findViewById(R.id.et_password_cp);

        profileImage=(ImageView )findViewById(R.id.iv_cp);

        SharedPreferences sharedPreferences=PreferenceManager.getDefaultSharedPreferences(this);
        String TEXT1 =sharedPreferences.getString("TEXT","");
        nName.setText(TEXT1);
        String txt1 =sharedPreferences.getString("txt","");
        nBio.setText(txt1);
        String Text1 =sharedPreferences.getString("Text","");
        nPassword.setText(Text1);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    //open gallery
               // Intent openGalleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
              //  startActivityForResult(openGalleryIntent,1000);
                   TEXT= nName.getText().toString();
                   txt=nBio.getText().toString();
                   Text=nPassword.getText().toString();

                   SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(ProfileEditActivity.this);

                   SharedPreferences.Editor editor =sharedPreferences.edit();
                  editor.putString("TEXT", TEXT);
                editor.putString("txt", txt);
                editor.putString("Text", Text);

                  editor.apply();
                Intent intent =new Intent(ProfileEditActivity.this,ProfileActivity.class);
                intent.putExtra("TEXT",TEXT);
                intent.putExtra("txt",txt);
                intent.putExtra("Text",Text);
                startActivity(intent);
                finish();
            }

        });

    }

 //   @Override
    //protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
     //   super.onActivityResult(requestCode, resultCode, data);
       // if(requestCode==1000){
          //  if(resultCode== Activity.RESULT_OK){
          //      Uri imageUri =data.getData();
             //   profileImage.setImageURI(imageUri);
          //  }
      //  }
  //  }
}