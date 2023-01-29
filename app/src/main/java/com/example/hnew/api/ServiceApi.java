package com.example.hnew.api;

import com.example.hnew.bean.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServiceApi {
    @GET("/toutiao/index?key=0eb03f97a50217a37c176579c5b947f4")
    Call<NewsResponse> getNews(@Query("type") String type);
}
