package com.example.myapplication.main;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.model.PostModel;
import com.example.myapplication.postDetails.PostDetails;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostAdapter extends RecyclerView.Adapter<PostHolder> {
    private List<PostModel> posts;
    private Context context ;

    public PostAdapter(List<PostModel> posts, Context context) {
        this.posts = posts;
        this.context = context;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post , parent,false);
        return new PostHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        PostModel post = posts.get(position);

        holder.titleTextView.setText(post.getTitle());
        holder.userIdTextView.setText(post.getUserId()+"");
        holder.bodyTextView.setText(post.getBody());

        holder.container.setOnClickListener(v -> {
            Intent i = new Intent(context , PostDetails.class);
            i.putExtra("ID" , post.getId());
            i.setFlags(i.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);

        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
}
