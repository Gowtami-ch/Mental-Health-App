package com.example.mentalhealthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
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

import org.json.JSONException;
import org.json.JSONObject;

public class MemeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meme);
        loadMeme();
    }
   public void loadMeme()
   {
       ImageView memeImageView=findViewById(R.id.memeImageView);
       RequestQueue queue = Volley.newRequestQueue(this);
       String url ="https://meme-api.herokuapp.com/gimme";
       JsonObjectRequest jsonObjectRequest  = new JsonObjectRequest(Request.Method.GET, url, null,
           new Response.Listener<JSONObject>() {
           @Override
           public void onResponse(JSONObject response)
           {
               try {
                   String url=response.getString("url");
               } catch (JSONException e) {
                   e.printStackTrace();
               }
               Glide.with(MemeActivity.this).load(url).into(memeImageView);
           }
       }, new Response.ErrorListener() {
           @Override
           public void onErrorResponse(VolleyError error)
           {
               Toast.makeText(MemeActivity.this, "Something went wrong ☹", Toast.LENGTH_SHORT).show();
           }
       });
// Add the request to the RequestQueue.
       queue.add(jsonObjectRequest );
   }
    public void ShareMeme(View view)
    {

    }

    public void nextMeme(View view)
    {
       loadMeme();
    }
}