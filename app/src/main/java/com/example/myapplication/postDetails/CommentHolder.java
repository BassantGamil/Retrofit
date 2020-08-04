package com.example.myapplication.postDetails;

import android.view.View;
import android.widget.TextView;

import com.example.myapplication.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CommentHolder extends RecyclerView.ViewHolder {
    public TextView name ;
    public TextView email ;
    public TextView body ;

    public CommentHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name_Comment_TextView);
        email = itemView.findViewById(R.id.email_Comment_TextView);
        body = itemView.findViewById(R.id.body_Comment_TextView);

    }
}
