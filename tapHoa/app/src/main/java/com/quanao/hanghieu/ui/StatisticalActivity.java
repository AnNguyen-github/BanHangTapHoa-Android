package com.quanao.hanghieu.ui;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;
import com.quanao.hanghieu.R;


import com.quanao.hanghieu.adapter.ManagerListAdapter;
import com.quanao.hanghieu.adapter.StatisticalAdapter;
import com.quanao.hanghieu.data.Cart;
import com.quanao.hanghieu.data.Order;
import com.quanao.hanghieu.data.Utils;
import com.quanao.hanghieu.service.APIHeroku;
import com.quanao.hanghieu.service.HerokuService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StatisticalActivity extends AppCompatActivity {
    ListView listView;
    List<Cart> carts;
    ManagerListAdapter adapter;
    Button btnBack,btnThongKe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_statistical);


        carts = new ArrayList<>();
        btnBack = findViewById(R.id.btnBack_manager);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnThongKe = findViewById(R.id.btnThongKe);
        btnThongKe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StatisticalActivity.this,ThongKeActivity.class);

                startActivity(intent);
                finish();
            }
        });

        listView = findViewById(R.id.managerList);
        //APIHeroku.getHerokuService();
        HerokuService service = APIHeroku.herokuService;
        Call<List<Cart>> createCall = service.getCart();
        createCall.enqueue(new Callback<List<Cart>>() {
            @Override
            public void onResponse(Call<List<Cart>> call, Response<List<Cart>> response) {
                carts = response.body();
                adapter = new ManagerListAdapter(StatisticalActivity.this,carts);
                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Cart>> call, Throwable t) {

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent= new Intent(StatisticalActivity.this,StatisticalDetail.class);
                intent.putExtra("cart",carts.get(i));
                intent.putExtra("state","1");
                startActivity(intent);


            }
        });

    }
}