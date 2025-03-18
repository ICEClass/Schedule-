package com.example.hitwhcampusapp;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.hitwhcampusapp.mine.MineFragment;
import com.example.hitwhcampusapp.querycredits.QueryCreditsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private QueryCreditsFragment queryCreditsFragment;
    private MineFragment mineFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //设置底部导航栏
        setBottomNavigation();
    }

    public void setBottomNavigation() {
        //初始化控件
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav);

        //默认第一页被选中
        selectedFragment(0);

        //点击底部导航栏按钮切换界面
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.bottom_nav_query_credits) selectedFragment(0);
                else if (item.getItemId() == R.id.bottom_nav_mine) selectedFragment(1);
                return true;
            }
        });
    }

    public void selectedFragment(int position) {
        //获取FragmentManager管理器
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideFragment(transaction);
        if (position == 0) {
            if (queryCreditsFragment == null) {
                queryCreditsFragment = new QueryCreditsFragment();
                transaction.add(R.id.frame_content, queryCreditsFragment);
            }
            else transaction.show(queryCreditsFragment);
        }
        else if (position == 1) {
            if (mineFragment == null) {
                mineFragment = new MineFragment();
                transaction.add(R.id.frame_content, mineFragment);
            } else transaction.show(mineFragment);
        }

        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction) {
        if (queryCreditsFragment != null) transaction.hide(queryCreditsFragment);
        if (mineFragment != null) transaction.hide(mineFragment);
    }
}