package com.quanao.hanghieu.service;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import com.quanao.hanghieu.R;

import androidx.appcompat.app.AppCompatActivity;

import com.quanao.hanghieu.TestActivity;
import com.quanao.hanghieu.data.Product;
import com.quanao.hanghieu.data.Utils;
import com.quanao.hanghieu.service.LoginActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WelcomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        APIHeroku.getHerokuService();
        HerokuService service = APIHeroku.herokuService;
        Call<List<Product>> createCall = service.all();
        createCall.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                for(Product p : response.body())
                {
                    Utils.addToProduct(p);
                }

                Intent i = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(i);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }

        });
    }
}