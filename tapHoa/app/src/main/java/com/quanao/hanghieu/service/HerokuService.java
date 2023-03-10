package com.quanao.hanghieu.service;

import com.quanao.hanghieu.data.Cart;
import com.quanao.hanghieu.data.Order;
import com.quanao.hanghieu.data.Product;

import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface HerokuService {
    @GET("api/product")
    Call<List<Product>> all();

    @GET("api/product/{name}")
    Call<Product> get(@Path("name") String product);

    @POST("api/sold")
    Call<Cart> sold(@Body Cart user);
    @POST("api/product")
    Call<Product> create(@Body Product user);

    @DELETE("api/cart/{name}")
    Call<List<Cart>> deleteItem(@Path("name") String name);

    @GET("api/cart")
    Call<List<Cart>> allCart();

    //Order
    @GET("api/cart")
    Call<List<Order>> allOrder();



    @GET("api/cart/{name}")
    Call<Cart> getCart(@Path("name") String s);

    @GET("api/cart/")
    Call<List<Cart>> getCart();

    @POST("api/cart")
    Call<Cart> createCart(@Body Cart user);
    @POST("api/cart")
    Call<Order> createOrder(Order order);

    @GET("api/sold")
    Call<List<Cart>> callSold();
}
