package com.example.admin.convenientbannerdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.admin.convenientbannerdemo.ui.ViewPagerLocalActivity;
import com.example.admin.convenientbannerdemo.ui.ViewPagerNetActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListener();
    }

    private void setListener() {
        findViewById(R.id.btn_local).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, ViewPagerLocalActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_net).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, ViewPagerNetActivity.class);
                startActivity(intent);
            }
        });
    }

}
