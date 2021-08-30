package com.example.mentalhealthapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import org.json.JSONException;
import org.json.JSONObject;

public class MemeActivity extends AppCompatActivity {
    ImageView memeImageView;
    String currenturl="";
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meme);
        loadMeme();
    }
   public void loadMeme()
   {
       progressBar=findViewById(R.id.progressBar);
       memeImageView=findViewById(R.id.memeImageView);
       RequestQueue queue = Volley.newRequestQueue(this);
       progressBar.setVisibility(View.VISIBLE);
       String url ="https://meme-api.herokuapp.com/gimme/wholesomememes";
       JsonObjectRequest jsonObjectRequest  = new JsonObjectRequest(Request.Method.GET, url, null,
           new Response.Listener<JSONObject>() {
           @Override
           public void onResponse(JSONObject response)
           {
               try {
                    currenturl =response.getString("url");
               } catch (JSONException e) {
                   e.printStackTrace();
               }
               Glide.with(MemeActivity.this).load(currenturl).listener(new RequestListener<Drawable>() {
                   @Override
                   public boolean onLoadFailed(@Nullable @org.jetbrains.annotations.Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource)
                   {
                       progressBar.setVisibility(View.GONE);
                       return false;
                   }

                   @Override
                   public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource)
                   {
                       progressBar.setVisibility(View.GONE);
                       return false;
                   }
               }).into(memeImageView);
           }
       }, new Response.ErrorListener() {
           @Override
           public void onErrorResponse(VolleyError error)
           {
               Toast.makeText(MemeActivity.this, "Something went wrong ☹", Toast.LENGTH_SHORT).show();
           }
       });
       queue.add(jsonObjectRequest );
   }
    public void ShareMeme(View view)
    {
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plane");
        intent.putExtra(Intent.EXTRA_TEXT,"Hey , Checkout this cool meme I got from Mental-health-App "+currenturl);
        startActivity(Intent.createChooser(intent, "Share this meme Using..."));
    }
    public void nextMeme(View view)
    {
       loadMeme();
    }
}
