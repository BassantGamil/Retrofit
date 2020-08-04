package com.example.myapplication.data.network.api;

import com.example.myapplication.model.PostModel;
import com.example.myapplication.model.CommentsModel;
import com.example.myapplication.util.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET(Constants.GET_ALL_POSTS)
    Call <List<PostModel>> getAllPost();

    @GET(Constants.GET_POST)
    Call <PostModel> getPost(@Path("id") int postID);

    @GET(Constants.GET_ALL_COMMENTS)
    Call<List<CommentsModel>> getComments(@Path("id") int postID);

    @GET(Constants.GET_ALL_USERS)
    Call <List<PostModel>> getAllUsers (@Query("userId") int userId);
}
