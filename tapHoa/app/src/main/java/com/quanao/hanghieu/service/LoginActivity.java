package com.quanao.hanghieu.service;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.quanao.hanghieu.R;
import com.quanao.hanghieu.User;
import com.quanao.hanghieu.data.Utils;
import com.quanao.hanghieu.ui.HomeActivity;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    //private FirebaseAuth mAuth;
    //DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://userauth-78e07-default-rtdb.firebaseio.com/");
    Button btn_login_finger;
    //Button btn_Signin, btnRegisters,
    Button btnCancel,btnOK;
    boolean notNull = false;
    //BroadcastReceiver broadcastReceiver;
    List<User> listUser;
    EditText edtUsername;
    EditText edtPassword;
    Button btn_Signin;
    Button btnRegisters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.e("TAG", "onCreate: "+Utils.productItems.size() );
        setContentView(R.layout.activity_login);

        btn_login_finger = findViewById(R.id.btn_finger);
        btn_login_finger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, LoginFingerActivity.class);
                startActivity(intent);
            }
        });

        edtUsername = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);
       btn_Signin = findViewById(R.id.btnSignin);
          btnRegisters = findViewById(R.id.btnRegister);
        listUser = new ArrayList<>();

        Log.e("TAG", "onCreate: "+listUser.size() );
        btn_Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(edtUsername.getText().toString().isEmpty() ||
                        edtPassword.getText().toString().isEmpty()){
                    final Dialog dialog = new Dialog(LoginActivity.this);
                    dialog.setContentView(R.layout.dialog_custom);
                    btnOK = dialog.findViewById(R.id.btnOK);
                    btnCancel = dialog.findViewById(R.id.btnCancel);
                    btnOK.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                            startActivityForResult(intent, 100);
                            dialog.dismiss();
                        }
                    });
                    btnCancel.setOnClickListener(new View.OnClickListener() {
                        @Override

                        public void onClick(View view) {
                            dialog.cancel();
                        }
                    });
                    dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                            WindowManager.LayoutParams.WRAP_CONTENT);
                    dialog.show();
                }else if(edtPassword.getText().toString().length() < 6){
                    edtPassword.setError("Minimum 6 number");
                }
                else
                {
                    Utils.username = edtUsername.getText().toString();
                    getListUser();
                }
            }
        });
        btnRegisters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivityForResult(intent,100);
            }
        });
    }

    private void getListUser() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://grocery-master.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final UsersService usersService = retrofit.create(UsersService.class);
        usersService.all().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                listUser = response.body();
                for (User user : listUser)
                {
                    if (edtUsername.getText().toString().equals(user.getUsername())
                            &&edtPassword.getText().toString().equals(user.getPassword()))
                    {
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        intent.putExtra("username",edtUsername.getText().toString());
                        intent.putExtra("password",edtPassword.getText().toString());
                        Log.e("user",edtUsername.getText().toString());
                        Log.e("pass",edtPassword.getText().toString());
                        startActivity(intent);
                        Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    }




                }



            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Call api fail", Toast.LENGTH_SHORT).show();
            }
        });
    }
}