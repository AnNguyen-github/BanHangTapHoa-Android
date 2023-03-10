package com.quanao.hanghieu.service;

import com.quanao.hanghieu.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UsersService {
    @GET("api/users")
    Call<List<User>> all();

    @GET("api/users/{username}")
    Call<User> get (@Path("username") String username);


    @POST("api/users")
    Call<User> create(@Body User user);
}
