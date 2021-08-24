package com.example.mentalhealthapp;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;

public class CalendarViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final CalendarAdapter.OnItemListener onItemListener;

    public BreakIterator dayOfMonth;
    private Object String;

    public CalendarViewHolder(@NonNull View itemView, CalendarAdapter.OnItemListener onItemListener) {
        super(itemView);
        View dayOfMonth = itemView.findViewById(R.id.cellDayText);
        this.onItemListener = onItemListener;
        itemView.setOnClickListener(this);
    }
    private BreakIterator getDayOfMonth() {
        return dayOfMonth;
    }
    @Override
    public void onClick(View view) {
        onItemListener.onItemClick(getAdapterPosition(),
                (String).dayOfMonth(dayOfMonth.getText()));
    }

}
