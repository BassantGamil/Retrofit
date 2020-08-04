package com.example.myapplication.showAllPosts;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.data.network.api.ApiClient;
import com.example.myapplication.data.network.api.ApiService;
import com.example.myapplication.model.PostModel;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowAllPosts extends AppCompatActivity {
    private int USERID;
    private ApiService api;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        recyclerView = findViewById(R.id.postsOfUserRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        USERID = getIntent().getIntExtra("USERID", 0);
        api = ApiClient.getInstance(this);
        getShowPosts();
    }

    private void getShowPosts() {
        api.getAllUsers(USERID).enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                Log.v("RESPONSE", response.body() + "");
                if (response.body() != null) {
                    ShowAllPostsAdapter showAllPostsAdapter = new ShowAllPostsAdapter(response.body(), getApplicationContext());
                    recyclerView.setAdapter(showAllPostsAdapter);
                } else
                    Toast.makeText(ShowAllPosts.this, "error for posts for one user", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                Log.v("ERROR_FROM_SERVER", t.getMessage());
                Toast.makeText(ShowAllPosts.this, "error for posts for one user", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
