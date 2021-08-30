package com.example.mentalhealthapp;

import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentalhealthapp.model.Cards;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder>{
    Context context;
    List<Cards> cardsList;

    public MainAdapter(Context context, List<Cards> cardsList) {
        this.context = context;
        this.cardsList = cardsList;
    }

    @NonNull
    @Override
    public MainAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.MyViewHolder holder, int position) {
        int val = position;
        holder.profileImage.setImageResource(cardsList.get(position).getImageProfile());
        holder.cardtext.setText(cardsList.get(position).getCardtext());

        switch(val){
            case 0:
                holder.constraintLayout.setBackgroundColor(Color.parseColor("#FFA07A"));
                break;
            case 1:
                holder.constraintLayout.setBackgroundColor(Color.parseColor("#FF69B4"));
                break;
            case 2:
                holder.constraintLayout.setBackgroundColor(Color.parseColor("#9370DB"));
                break;
            case 3:
                holder.constraintLayout.setBackgroundColor(Color.parseColor("#BDB76B"));
                break;
            case 4:
                holder.constraintLayout.setBackgroundColor(Color.parseColor("#5F9EA0"));
                break;
            case 5:
                holder.constraintLayout.setBackgroundColor(Color.parseColor("#CD5C5C"));
                break;
            default:
                holder.constraintLayout.setBackgroundColor(Color.parseColor("#FFFFE0"));
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View view) {
                    Intent intent;
                    switch (val){
                        case 0:
                            intent = new Intent(context,QuizActivity.class);
                            context.startActivity(intent);
                            break;
                        case 1:
                            intent = new Intent(context,NewsActivity.class);
                            context.startActivity(intent);
                            break;
                        case 2:
                            intent = new Intent(context,MemeActivity.class);
                            context.startActivity(intent);
                            break;
                        case 3:
                            intent = new Intent(context,JournalActivity.class);
                            context.startActivity(intent);
                            break;
                        case 4:
                            intent = new Intent(context,ToDoListActivity.class);
                            context.startActivity(intent);
                            break;
                        case 5:
                            intent = new Intent(context,quizStatistics.class);
                            context.startActivity(intent);
                            break;

                    }
                }
        });

    }
    @Override
    public int getItemCount() {
        return cardsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CircleImageView profileImage;
        TextView cardtext;
        ConstraintLayout constraintLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            profileImage = itemView.findViewById(R.id.profileImage);
            cardtext = itemView.findViewById(R.id.cardtext);
            constraintLayout = itemView.findViewById(R.id.constraintLayout);
        }
    }
}
