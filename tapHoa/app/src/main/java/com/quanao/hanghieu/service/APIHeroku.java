package com.quanao.hanghieu.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIHeroku {
    public static HerokuService herokuService;

    public static HerokuService getHerokuService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://apitaphoa.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        herokuService = retrofit.create(HerokuService.class);
        return herokuService;
    }


}
