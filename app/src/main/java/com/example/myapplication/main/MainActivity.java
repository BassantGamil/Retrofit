package com.example.myapplication.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.data.network.api.ApiClient;
import com.example.myapplication.data.network.api.ApiService;
import com.example.myapplication.model.PostModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ApiService apiService ;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiService = ApiClient.getInstance(this);
        recyclerView = findViewById(R.id.postRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.VERTICAL,false));

        getAllPost();
    }

    private void getAllPost() {
        apiService.getAllPost().enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                PostAdapter postAdapter = new PostAdapter(response.body() , getApplicationContext());
                recyclerView.setAdapter(postAdapter);
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this , "Please check your connection " , Toast.LENGTH_SHORT).show();
            }
        });
    }
}
