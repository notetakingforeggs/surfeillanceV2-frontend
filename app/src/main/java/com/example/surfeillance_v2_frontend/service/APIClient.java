package com.example.surfeillance_v2_frontend.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private static Retrofit retrofit;

    private APIClient(){

    }

    public static Retrofit getInstance(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/api/v1")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

}
