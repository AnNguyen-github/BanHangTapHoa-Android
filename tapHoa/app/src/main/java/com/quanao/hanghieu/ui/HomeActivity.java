package com.quanao.hanghieu.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;

import com.quanao.hanghieu.MainActivity;
import com.quanao.hanghieu.R;
import com.quanao.hanghieu.adapter.HomeSliderAdapter;
import com.quanao.hanghieu.data.Product;
import com.quanao.hanghieu.databinding.ActivityHomeBinding;

import com.quanao.hanghieu.fragment.CartViewFragment;
import com.quanao.hanghieu.fragment.CategoriesFragment;
import com.quanao.hanghieu.fragment.DashboardFragment;
import com.quanao.hanghieu.fragment.GridItemFragment;
import com.quanao.hanghieu.fragment.ProfileFragment;
import com.quanao.hanghieu.fragment.SearchFragment;
import com.quanao.hanghieu.service.APIHeroku;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity {

    SearchView searchView;
    SearchFragment searchFragment;
    CategoriesFragment categoriesFragment;
    GridItemFragment listItemFragment;
    ActivityHomeBinding binding;
    CartViewFragment cartViewFragment;
    DashboardFragment dashboardFragment;
    ProfileFragment profileFragment;
    StatisticalActivity statisticalActivity;



    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        APIHeroku.getHerokuService();



        searchFragment = new SearchFragment();
        categoriesFragment = new CategoriesFragment();
        listItemFragment = new GridItemFragment();
        cartViewFragment = new CartViewFragment();
        dashboardFragment = new DashboardFragment();
        profileFragment = new ProfileFragment();
        statisticalActivity = new StatisticalActivity();



        reloadMainFragment(categoriesFragment);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.bottomNavigationView.setOnItemSelectedListener(item ->{
            switch (item.getItemId())
            {
                case R.id.homeFragment:
                    reloadMainFragment(categoriesFragment);
                    break;
                case R.id.cartViewFragment:
                    reloadMainFragment(cartViewFragment);
                    break;
                case R.id.nav_dashboard:
                    reloadMainFragment(dashboardFragment);
                    break;

                case R.id.nav_statiscal:
                    Intent statistical = new Intent(getApplicationContext(),StatisticalActivity.class);
                    startActivity(statistical);
                    break;
                case R.id.nav_profile:
                    reloadMainFragment(profileFragment);
                    break;
            }
            return true;
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        searchView = findViewById(R.id.search_view);

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_search,menu);
        MenuItem menuItem = menu.findItem(R.id.search_view);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reloadMainFragment(searchFragment);
            }
        });
       searchView.setOnCloseListener(new SearchView.OnCloseListener() {
           @Override
           public boolean onClose() {
               reloadMainFragment(categoriesFragment );
               return false;
           }
       });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                searchFragment.searchFurniture(s);
                if(s.isEmpty())
                {

                }
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
    public void reloadMainFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainerView, fragment)
                .commit();

    }



}