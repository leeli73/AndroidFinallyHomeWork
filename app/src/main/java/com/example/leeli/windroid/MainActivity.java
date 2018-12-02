package com.example.leeli.windroid;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.os.Build;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {
    private WebView LoginBackground;
    private Button LoginButton;
    private Button RegisterButton;
    private TextView Username;
    private TextView Password;
    private CheckBox isRemember;
    private CheckBox isAuto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitImmersionModel();
        InitLoginBackground();
        InitAlpha();
        Init();
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent body = new Intent(MainActivity.this,body.class);
                startActivity(body);
            }
        });
    }
    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
        Toast.makeText(MainActivity.this,"Windroid进入后台运行",Toast.LENGTH_SHORT).show();
    }
    public void Init()
    {
        LoginButton = (Button)findViewById(R.id.Login);
        RegisterButton = (Button)findViewById(R.id.Register);
        Username = (TextView)findViewById(R.id.Username);
        Password = (TextView)findViewById(R.id.Password);
        isRemember = (CheckBox)findViewById(R.id.checkBoxRemember);
        isAuto = (CheckBox)findViewById(R.id.checkBoxAutoLogin);
        isAuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isAuto.isChecked())
                {
                    isRemember.setChecked(true);
                }
                else
                {
                    isRemember.setChecked(false);
                }
            }
        });
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
    public void InitLoginBackground() //加载背景动画
    {
        LoginBackground = (WebView)findViewById(R.id.LoginBackground);
        //LoginBackground.getSettings().setJavaScriptEnabled(true);
        //LoginBackground.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        //LoginBackground.getSettings().setLoadWithOverviewMode(true);
        LoginBackground.loadUrl("file:///android_asset/LoginBackground.html");
    }
    public void InitAlpha()
    {
        View LoginCard = findViewById(R.id.LoginCard);
        LoginCard.setAlpha(0.9f);
        //View AllButton = findViewById(R.id.AllButton);
        //AllButton.setAlpha(0.9f);
    }
}

