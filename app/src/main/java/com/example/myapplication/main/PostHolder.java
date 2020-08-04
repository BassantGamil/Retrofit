package com.example.myapplication.main;

import android.view.View;
import android.widget.TextView;

import com.example.myapplication.R;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class PostHolder extends RecyclerView.ViewHolder {
    public TextView titleTextView;
    public TextView bodyTextView;
    public TextView userIdTextView;
    public CardView container ;

    public PostHolder(@NonNull View itemView) {
        super(itemView);
        titleTextView = itemView.findViewById(R.id.title_post_textView);
        bodyTextView = itemView.findViewById(R.id.body_post_textView);
        userIdTextView = itemView.findViewById(R.id.userId_post_textView);
        container = itemView.findViewById(R.id.container);
    }
}
