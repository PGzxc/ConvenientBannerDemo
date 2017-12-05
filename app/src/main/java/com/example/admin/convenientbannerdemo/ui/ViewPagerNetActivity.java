package com.example.admin.convenientbannerdemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.example.admin.convenientbannerdemo.R;
import com.example.admin.convenientbannerdemo.holder.NetImageHolder;
import com.example.admin.convenientbannerdemo.utils.Utils;

import java.util.Arrays;

/**
 * Created by admin on 2017/12/5.
 */

public class ViewPagerNetActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, OnItemClickListener {
    private static final String TAG = ViewPagerNetActivity.class.getSimpleName();
    private ConvenientBanner bannerNet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net);
        initView();
        initData();
    }


    private void initView() {
        bannerNet = findViewById(R.id.banner_net);
    }

    private void initData() {
        bannerNet.setPages(new CBViewHolderCreator<NetImageHolder>() {
            @Override
            public NetImageHolder createHolder() {
                return new NetImageHolder();
            }
        }, Arrays.asList(Utils.images))
                .setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused})
                .setOnPageChangeListener(this)
                .setOnItemClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        bannerNet.startTurning(3000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        bannerNet.stopTurning();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Log.d(TAG, "监听到翻到第" + position + "了");

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(this, "点击了第：" + position + "个", Toast.LENGTH_SHORT).show();
    }
}
