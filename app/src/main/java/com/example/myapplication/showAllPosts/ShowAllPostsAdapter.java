package com.example.myapplication.showAllPosts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.model.PostModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ShowAllPostsAdapter extends RecyclerView.Adapter<ShowAllPostsHolder> {
    private List<PostModel> postModels ;
    private Context context ;

    public ShowAllPostsAdapter(List<PostModel> postModels, Context context) {
        this.postModels = postModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ShowAllPostsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user , parent , false);
        return new ShowAllPostsHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowAllPostsHolder holder, int position) {
        PostModel postModel = postModels.get(position);

        holder.userIdTextView.setText(postModel.getUserId()+"");
        holder.idTextView.setText(postModel.getId()+"");
        holder.titleTextView.setText(postModel.getTitle());
        holder.bodyTextView.setText(postModel.getBody());
    }

    @Override
    public int getItemCount() {
        return postModels.size();
    }
}
