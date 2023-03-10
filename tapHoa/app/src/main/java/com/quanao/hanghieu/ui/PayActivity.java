package com.quanao.hanghieu.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import com.quanao.hanghieu.R;

import com.quanao.hanghieu.MainActivity;
import com.quanao.hanghieu.data.Cart;
import com.quanao.hanghieu.data.CartItem;
import com.quanao.hanghieu.data.Order;
import com.quanao.hanghieu.data.Utils;
import com.quanao.hanghieu.service.APIHeroku;
import com.quanao.hanghieu.service.HerokuService;
import com.quanao.hanghieu.service.UsersService;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import okhttp3.internal.Util;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PayActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView total;
    EditText name,phone,email,location;
    Button btnDatHang;

    HerokuService service = APIHeroku.herokuService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        initView();
        APIHeroku.getHerokuService();
        initControl();
        btnDatHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1 = name.getText().toString().trim();
                String phone1 = phone.getText().toString().trim();
                String email1 = email.getText().toString().trim();
                String location1 = location.getText().toString().trim();
                String total1 = total.getText().toString().trim();
                if (TextUtils.isEmpty(name1) || TextUtils.isEmpty(phone1) || TextUtils.isEmpty(email1) || TextUtils.isEmpty(location1)){
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }else {
                    Date date = Calendar.getInstance().getTime();


                    List<CartItem> z = new ArrayList<>();
                    z = Utils.lstCart;
                    Cart cart = new Cart(email1,name1,location1,z,date.toString(),phone1);

                    Log.e("TAG", "onClick: "+cart.getName() );
                    Log.e("TAG", "onClick: "+cart.getListorder().size() );
                    Log.e("TAG", "onClick: "+cart.getAddress() );

                    Call<Cart> createCall2 = service.createCart(cart);
                    createCall2.enqueue(new Callback<Cart>() {
                        @Override
                        public void onResponse(Call<Cart> call, Response<Cart> response) {


                        }

                        @Override
                        public void onFailure(Call<Cart> call, Throwable t) {

                        }
                    });
                    Utils.lstCart.clear();
                    finish();
                }
            }
        });
    }

    private void initControl() {


        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        String tong = getIntent().getExtras().getString("total");
        total.setText(String.valueOf(tong));
    }

    private void initView() {

        toolbar = findViewById(R.id.toolbar_pay);
        total = findViewById(R.id.total_pay);
        name = findViewById(R.id.name_pay);
        phone = findViewById(R.id.phone_pay);
        email = findViewById(R.id.email_pay);
        location = findViewById(R.id.location_pay);
        btnDatHang = findViewById(R.id.btnPay);

    }
}