package com.example.myapplication.util;

public class Constants {

    //////////////////////////////// Network ///////////////////////////////////////////
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    public static final String GET_ALL_POSTS = BASE_URL + "posts/";
    public static final String GET_POST = GET_ALL_POSTS + "{id}/";
    public static final String GET_ALL_COMMENTS = GET_ALL_POSTS + "{id}/comments/";

    public static final String GET_ALL_USERS = BASE_URL + "posts";
}
//https://jsonplaceholder.typicode.com/posts?userId=1