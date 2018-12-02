package com.example.leeli.windroid;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.os.Build;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageNavigationView;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener;

public class body extends AppCompatActivity {
    private ViewPager vpager_one;
    private ArrayList<View> aList;
    private MyPagerAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.body);
        InitImmersionModel();
        PageNavigationView tab = (PageNavigationView)findViewById(R.id.tab);
        NavigationController navigationController = tab.material()
                .addItem(android.R.drawable.ic_menu_manage, "应用设置")
                .addItem(android.R.drawable.ic_menu_myplaces, "个人信息")
                .build();
        navigationController.addTabItemSelectedListener(new OnTabItemSelectedListener() {
            @Override
            public void onSelected(int index, int old) {
                Toast.makeText(body.this,"Old:"+old+" Index:"+index,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRepeat(int index) {
                //重复选中时触发
            }
        });
        vpager_one = (ViewPager) findViewById(R.id.up);
        aList = new ArrayList<View>();
        LayoutInflater li = getLayoutInflater();
        aList.add(li.inflate(R.layout.seeting,null,false));
        aList.add(li.inflate(R.layout.person,null,false));
        mAdapter = new MyPagerAdapter(aList);
        vpager_one.setAdapter(mAdapter);

    }
    public void InitImmersionModel() //沉浸模式
    {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
        Toast.makeText(body.this,"Windroid进入后台运行",Toast.LENGTH_SHORT).show();
    }
}
