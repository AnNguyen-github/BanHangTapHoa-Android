package com.quanao.hanghieu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.quanao.hanghieu.data.Cart;
import com.quanao.hanghieu.data.Product;
import com.quanao.hanghieu.service.APIHeroku;
import com.quanao.hanghieu.service.HerokuService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        HerokuService service = APIHeroku.herokuService;

    }
}