package com.example.myapplication.postDetails;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.model.CommentsModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CommentAdapter extends RecyclerView.Adapter<CommentHolder> {

    private List<CommentsModel> comments;
    private Context context;

    public CommentAdapter(List<CommentsModel> comments, Context context) {
        this.comments = comments;
        this.context = context;
    }

    @NonNull
    @Override
    public CommentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment, parent, false);
        return new CommentHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentHolder holder, int position) {
        CommentsModel comment = comments.get(position);

        holder.name.setText(comment.getName());
        holder.email.setText(comment.getEmail());
        holder.body.setText(comment.getBody());
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }
}
