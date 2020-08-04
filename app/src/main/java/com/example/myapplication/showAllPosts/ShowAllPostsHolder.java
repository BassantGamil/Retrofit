package com.example.myapplication.showAllPosts;

import android.view.View;
import android.widget.TextView;

import com.example.myapplication.R;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ShowAllPostsHolder extends RecyclerView.ViewHolder {
    public TextView titleTextView;
    public TextView bodyTextView;
    public TextView userIdTextView;
    public TextView idTextView;
    public CardView container ;

    public ShowAllPostsHolder(@NonNull View itemView) {
        super(itemView);
        titleTextView = itemView.findViewById(R.id.title_user_textView);
        bodyTextView = itemView.findViewById(R.id.body_user_textView);
        userIdTextView = itemView.findViewById(R.id.userId_user_textView);
        idTextView = itemView.findViewById(R.id.id_user_textView);
    }
}
