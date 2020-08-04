package com.example.myapplication.postDetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.data.network.api.ApiClient;
import com.example.myapplication.data.network.api.ApiService;
import com.example.myapplication.model.CommentsModel;
import com.example.myapplication.model.PostModel;
import com.example.myapplication.showAllPosts.ShowAllPosts;

import java.util.List;

public class PostDetails extends AppCompatActivity {
    private int USERID;
    private int postId;

    private ApiService api;

    private TextView userId;
    private TextView title;
    private TextView body;
    private TextView id;
    private TextView showAll;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);

        userId = findViewById(R.id.userId_postDetails_TextView);
        showAll = findViewById(R.id.showAll_postDetails_TextView);
        id = findViewById(R.id.id_postDetails_TextView);
        title = findViewById(R.id.title_postDetails_TextView);
        body = findViewById(R.id.body_postDetails_TextView);
        recyclerView = findViewById(R.id.commentRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        postId = getIntent().getIntExtra("ID", 0);
        api = ApiClient.getInstance(this);
        getPost();
        getComment();
    }


    private void getPost() {
        api.getPost(postId).enqueue(new Callback<PostModel>() {
            @Override
            public void onResponse(Call<PostModel> call, Response<PostModel> response) {
                USERID = response.body().getUserId();
                userId.setText(response.body().getUserId() + "");
                showAll.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(getApplicationContext(), ShowAllPosts.class);
                        i.putExtra("USERID", USERID);
                        startActivity(i);
                    }
                });

                id.setText(response.body().getId() + "");
                title.setText(response.body().getTitle());
                body.setText(response.body().getBody());

            }

            @Override
            public void onFailure(Call<PostModel> call, Throwable t) {
                Toast.makeText(PostDetails.this, "Please check your connection", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getComment() {
        api.getComments(postId).enqueue(new Callback<List<CommentsModel>>() {
            @Override
            public void onResponse(Call<List<CommentsModel>> call, Response<List<CommentsModel>> response) {
                CommentAdapter commentAdapter = new CommentAdapter(response.body(), getApplicationContext());
                recyclerView.setAdapter(commentAdapter);
            }

            @Override
            public void onFailure(Call<List<CommentsModel>> call, Throwable t) {
                Toast.makeText(PostDetails.this, "Error", Toast.LENGTH_LONG).show();
            }
        });
    }

}
